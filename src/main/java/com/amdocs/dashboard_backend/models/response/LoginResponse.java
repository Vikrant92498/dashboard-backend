package com.amdocs.dashboard_backend.models.response;

public class LoginResponse {
    private Boolean success;
    private String message;
    private String role;
    private String authToken;
    public LoginResponse() {}

    public LoginResponse(Boolean success, String message, String role, String authToken) {
        this.success = success;
        this.message = message;
        this.role = role;
        this.authToken = authToken;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
