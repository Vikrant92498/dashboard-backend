package com.amdocs.dashboard_backend.exceptions;

import com.amdocs.dashboard_backend.models.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<Object> handleTokenExpiredException(TokenExpiredException ex) {
        // Create a custom error response
        ErrorResponse errorResponse = new ErrorResponse(
                "Unauthorized",
                "Token has expired. Please login again.",
                "TOKEN_EXPIRED","401"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(UnauthorizedAccess.class)
    public ResponseEntity<Object> handleUnauthorizedAccessException(UnauthorizedAccess ex) {
        // Create a custom error response
        ErrorResponse errorResponse = new ErrorResponse(
                "Unauthorized",
                 ex.getMessage(),
                "Access restricted to limited users only",
                "401"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
    }
}
