package com.amdocs.dashboard_backend.services;

import com.amdocs.dashboard_backend.models.Admin;
import com.amdocs.dashboard_backend.models.AdminRes;
import com.amdocs.dashboard_backend.repositories.interfaces.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServicesImpl implements AdminServices{
    private final AdminRepository adminRepository;

    public AdminServicesImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminRes getAdminById(String id) {
        return adminRepository.findById(id);
    }
}
