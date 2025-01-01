package com.amdocs.dashboard_backend.services.implementations;

import com.amdocs.dashboard_backend.models.response.LoginResponse;
import com.amdocs.dashboard_backend.repositories.interfaces.AuthRepository;
import com.amdocs.dashboard_backend.services.interfaces.AuthServices;
import org.springframework.stereotype.Service;

@Service
public class AuthServicesImpl implements AuthServices {
    private final AuthRepository authRepository;

    public AuthServicesImpl(AuthRepository authRepository){
        this.authRepository=authRepository;
    }
    @Override
    public LoginResponse login(String email, String password){
        return authRepository.login(email,password);
    }
}
