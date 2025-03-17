package com.example.pibbletvbackend.business.implementations;

import com.example.pibbletvbackend.business.interfaces.KeycloakService;
import com.example.pibbletvbackend.persistance.entities.UserEntity;
import com.example.pibbletvbackend.persistance.jpa.UserRepository;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class KeycloakServiceImpl implements KeycloakService {

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    @Autowired
    private UserRepository userRepository;

    public void registerUser(String username, String email, String password, String backgroundPicPath, String profilePicPath) throws Exception {
        String registrationUrl = authServerUrl + "/realms/" + realm + "/protocol/openid-connect/registrations";

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(registrationUrl);

        // Read and encode images as Base64
        String base64BackgroundPic = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(backgroundPicPath)));
        String base64ProfilePic = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(profilePicPath)));

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("client_id", clientId));
        params.add(new BasicNameValuePair("client_secret", clientSecret));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("grant_type", "password"));

        post.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();

        if (statusCode == 201) {
            System.out.println("User registered successfully");


            String userId = fetchUserIdFromKeycloak(email);
            if (userId == null) {
                throw new Exception("Failed to retrieve user ID from Keycloak.");
            }


            UserEntity user = UserEntity.builder()
                    .id(userId)
                    .username(username)
                    .bgImage(Base64.getDecoder().decode(base64BackgroundPic))
                    .profileImage(Base64.getDecoder().decode(base64ProfilePic))
                    .build();

            userRepository.save(user);
            System.out.println("User saved to database with ID: " + userId);
        } else {
            String responseBody = EntityUtils.toString(response.getEntity());
            throw new Exception("Failed to register user: " + responseBody);
        }
    }

    public String authenticateUser(String email, String password) throws Exception {
        String tokenUrl = authServerUrl + "/realms/" + realm + "/protocol/openid-connect/token";

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(tokenUrl);


        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("client_id", clientId));
        params.add(new BasicNameValuePair("client_secret", clientSecret));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("grant_type", "password"));

        post.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(post);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }


    public String validateToken(String token) throws Exception {
        String introspectUrl = authServerUrl + "/realms/" + realm + "/protocol/openid-connect/token/introspect";

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(introspectUrl);


        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("client_id", clientId));
        params.add(new BasicNameValuePair("client_secret", clientSecret));
        params.add(new BasicNameValuePair("token", token));

        post.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(post);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }

    // Refresh a token
    public String refreshToken(String refreshToken) throws Exception {
        String tokenUrl = authServerUrl + "/realms/" + realm + "/protocol/openid-connect/token";

        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(tokenUrl);


        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("client_id", clientId));
        params.add(new BasicNameValuePair("client_secret", clientSecret));
        params.add(new BasicNameValuePair("refresh_token", refreshToken));
        params.add(new BasicNameValuePair("grant_type", "refresh_token"));

        post.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = client.execute(post);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}