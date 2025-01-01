package com.amdocs.dashboard_backend.services.interfaces;

import com.amdocs.dashboard_backend.models.response.LoginResponse;

public interface AuthServices {
    LoginResponse login(String email,String password);
}
