package com.amdocs.dashboard_backend.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "vikrant";
    private static final long expirationTime = 600000;
    public JwtUtil() {}

    // Function to generate a JWT token
    public static String generateToken(String email, String role, String name) {
        return JWT.create()
                .withSubject(email) // Store the email in the JWT subject claim
                .withClaim("role", role) // Store the user's role as a custom claim
                .withClaim("name", name) // Store the user's name as a custom claim
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime)) // Set expiration date based on passed time
                .withIssuer("coe-dashboard")  // Set the issuer of the token
                .sign(Algorithm.HMAC256(SECRET_KEY)); // Sign the token with the secret key
    }

    // Function to decode a JWT token and retrieve claims
    public static DecodedJWT decodeToken(String token) throws JWTVerificationException {
        // Create a JWTVerifier to validate the token using the same secret key
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY))
                .withIssuer("coe-dashboard") // Ensure the token is issued by the correct issuer
                .build();

        // Verify the token and decode it
        DecodedJWT decodedJWT = verifier.verify(token);

        return decodedJWT;
    }

    // Function to extract specific claims from the decoded token
    public static String getEmailFromToken(String token) throws JWTVerificationException {
        DecodedJWT decodedJWT = decodeToken(token);
        return decodedJWT.getSubject(); // The email is stored as the subject of the JWT
    }

    public static String getRoleFromToken(String token) throws JWTVerificationException {
        DecodedJWT decodedJWT = decodeToken(token);
        return decodedJWT.getClaim("role").asString(); // Retrieve the role claim
    }

    public static String getNameFromToken(String token) throws JWTVerificationException {
        DecodedJWT decodedJWT = decodeToken(token);
        return decodedJWT.getClaim("name").asString(); // Retrieve the name claim
    }

    public static Date getExpirationFromToken(String token) throws JWTVerificationException {
        DecodedJWT decodedJWT = decodeToken(token);
        return decodedJWT.getExpiresAt(); // Get the expiration date from the JWT
    }

    public static boolean isTokenValid(String token) throws JWTVerificationException {
        Date expirationTime = getExpirationFromToken(token);
        Date currentTime = new Date(System.currentTimeMillis());
        return expirationTime != null && expirationTime.after(currentTime); // Check if token is expired
    }

    public static void main(String[] args) {
        try {
            // Example usage
            String email = "vikrant@example.com";
            String role = "admin";
            String name = "Vikrant Sharma";

            // Generate a token
            String token = generateToken(email, role, name);
            System.out.println("Generated JWT: " + token);

            // Decode and extract information from the token
            String decodedEmail = getEmailFromToken(token);
            String decodedRole = getRoleFromToken(token);
            String decodedName = getNameFromToken(token);
            Date decodedExpiration = getExpirationFromToken(token);

            // Print decoded values
            System.out.println("Decoded Email: " + decodedEmail);
            System.out.println("Decoded Role: " + decodedRole);
            System.out.println("Decoded Name: " + decodedName);
            System.out.println("Decoded Expiration: " + decodedExpiration);

        } catch (JWTVerificationException exception) {
            System.out.println("Invalid token: " + exception.getMessage());
        }
    }
}
