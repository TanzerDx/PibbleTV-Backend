package com.pibbletv.keycloak.business.interfaces;

public interface KeycloakService {

    String registerUser(String email, String username, String password, String backgroundPic, String profilePic) throws Exception;

    String authenticateUser(String username, String password) throws Exception;

    String validateToken(String token) throws Exception;

    String refreshToken(String refreshToken) throws Exception;

}
