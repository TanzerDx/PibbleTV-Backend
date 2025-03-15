package com.example.pibbletvbackend.controller;

import com.example.pibbletvbackend.business.interfaces.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private KeycloakService keycloakService;

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