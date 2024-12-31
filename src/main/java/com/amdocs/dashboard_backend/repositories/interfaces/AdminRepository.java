package com.amdocs.dashboard_backend.repositories.interfaces;

import com.amdocs.dashboard_backend.models.AdminRes;

public interface AdminRepository {
    AdminRes findById(String id);
}
