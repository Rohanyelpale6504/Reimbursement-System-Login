package com.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Login.dto.LoginRequestDto;
import com.Login.dto.LoginResponceDto;
import com.Login.service.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Endpoint for handling login requests
    @PostMapping
    public ResponseEntity<LoginResponceDto> login(@RequestParam String username, @RequestParam String password) {
        // Call the login service to get the LoginRequestDto which includes the role
        LoginRequestDto loginRequestDto = loginService.login(username, password);

        // If authentication is successful, check role and return appropriate response
        if (loginRequestDto != null) {
            String role = loginRequestDto.getRole();
            switch (role) {
                case "admin":
                    // Return response for admin role
                    return ResponseEntity.ok(new LoginResponceDto( username, password,role));
                case "user":
                    // Return response for user role
                    return ResponseEntity.ok(new LoginResponceDto( username, password,role));
                case "manager":
                    // Return response for manager role
                    return ResponseEntity.ok(new LoginResponceDto( username, password,role));
                default:
                    // If role is unknown, return an error response
                    return ResponseEntity.status(401).body(new LoginResponceDto("Invalid role", username, password));
            }
        } else {
            // If authentication fails, return an error response
            return ResponseEntity.status(401).body(new LoginResponceDto("Invalid username or password", username, password));
        }
    }
}
