package com.example.pibbletvbackend.controller;

import com.example.pibbletvbackend.business.interfaces.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
public class AuthenticationController {

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping("/register")
    public void register(@RequestParam String username, @RequestParam String email, @RequestParam String password, @RequestParam String backgroundPic, @RequestParam String profilePic) {
        try {
            keycloakService.registerUser(username, email, password, backgroundPic, profilePic);
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        try {
            return keycloakService.authenticateUser(email, password);
        } catch (Exception e) {
            return "Authentication failed: " + e.getMessage();
        }
    }

    @PostMapping("/validate")
    public String validateToken(@RequestParam String token) {
        try {
            return keycloakService.validateToken(token);
        } catch (Exception e) {
            return "Token validation failed: " + e.getMessage();
        }
    }


    @PostMapping("/refresh")
    public String refreshToken(@RequestParam String refreshToken) {
        try {
            return keycloakService.refreshToken(refreshToken);
        } catch (Exception e) {
            return "Token refresh failed: " + e.getMessage();
        }
    }
}