package com.amdocs.dashboard_backend.models.response;

public class ErrorResponse {
    private String error;
    private String message;
    private String code;
    private String description;

    // Constructors
    public ErrorResponse() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ErrorResponse(String error, String message, String description, String code) {
        this.error = error;
        this.message = message;
        this.description=description;
        this.code = code;
    }

    // Getters and Setters
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
