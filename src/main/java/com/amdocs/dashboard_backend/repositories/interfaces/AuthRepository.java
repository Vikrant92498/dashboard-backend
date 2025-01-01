package com.amdocs.dashboard_backend.repositories.interfaces;

import com.amdocs.dashboard_backend.models.response.LoginResponse;

public interface AuthRepository {
    public LoginResponse login(String email,String password);
}
