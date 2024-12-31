package com.amdocs.dashboard_backend.interceptor;

import com.amdocs.dashboard_backend.exceptions.UnauthorizedAccess;
import com.amdocs.dashboard_backend.models.response.ErrorResponse;
import com.amdocs.dashboard_backend.utils.JwtUtil;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtAuthInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new UnauthorizedAccess("Missing or invalid token");
//            sendErrorResponse(response, "Unauthorized", "Missing or invalid token", "No token provided or token is empty","104");
//            return false;
        }

        try {
            // Decode and validate the token
            String role = JwtUtil.getRoleFromToken(token);
            String email = JwtUtil.getEmailFromToken(token);
            String name = JwtUtil.getNameFromToken(token);

            if (!JwtUtil.isTokenValid(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                throw new UnauthorizedAccess("Token has expired");

//                sendErrorResponse(response, "Unauthorized", "Token has expired", "The provided token has expired. Please login again.","103");
//                return false;
            }

            // Check role and request path
            String path = request.getRequestURI();
            if (path.startsWith("/api/v1/admin") && !role.equals("admin")) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                throw new UnauthorizedAccess("You are not authorized to perform this action");
                //sendErrorResponse(response, "Forbidden", "You are not authorized to perform this action", "Access restricted to admin users only","102");
                //return false;
            }

            else if (path.startsWith("/api/v1/employee") && !role.equals("employee")) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                throw new UnauthorizedAccess("You are not authorized to perform this action");

//                sendErrorResponse(response, "Forbidden", "You are not authorized to perform this action", "Access restricted to employee users only","101");
//                return false;
            }

        } catch (JWTVerificationException e) {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new UnauthorizedAccess("Invalid or expired token");

//            sendErrorResponse(response, "Unauthorized", "Invalid or expired token", "The provided token is invalid or expired. Please authenticate again.","100");
//            return false;
        }

        // If everything is valid, allow the request to proceed
        return true;
    }

//    private void sendErrorResponse(HttpServletResponse response, String error, String message, String description,String code) throws Exception {
//        ErrorResponse errorResponse = new ErrorResponse(error, message, description,code);
//        response.setContentType("application/json");
//        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
//    }
}