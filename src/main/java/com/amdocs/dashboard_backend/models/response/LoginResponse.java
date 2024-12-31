package com.amdocs.dashboard_backend.models.response;

public class LoginResponse<T> {
    private Boolean success;
    private String message;
    private String role;
    private String authToken;
    private T user;
    public LoginResponse() {}

    public LoginResponse(Boolean success, String message, String role, String authToken, T user) {
        this.success = success;
        this.message = message;
        this.role = role;
        this.authToken = authToken;
        this.user = user;
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

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }
}
