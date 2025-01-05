package com.amdocs.dashboard_backend.controllers;

import com.amdocs.dashboard_backend.models.response.LoginResponse;
import com.amdocs.dashboard_backend.services.interfaces.AuthServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AuthController {
    private final AuthServices authServices;
    public AuthController(AuthServices authServices){
        this.authServices=authServices;
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody Map<String, String> loginRequest) {
        try {
            // Extract email and password from the request body
            String email = loginRequest.get("email");
            String password = loginRequest.get("password");

            if (email == null || password == null) {
                return new ResponseEntity<>(new LoginResponse(false, "Email and password are required", null, null), HttpStatus.BAD_REQUEST);
            }

            // Call the login method from AuthServices
            LoginResponse response = authServices.login(email, password);

            // Return appropriate HTTP status based on the success field in the response
            return response.getSuccess()
                    ? new ResponseEntity<>(response, HttpStatus.OK)
                    : new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new LoginResponse(false, "An error occurred: " + e.getMessage(), null, null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
