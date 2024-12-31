package com.amdocs.dashboard_backend.repositories;

import com.amdocs.dashboard_backend.models.Admin;
import com.amdocs.dashboard_backend.models.AdminRes;

public interface AdminRepository {
    AdminRes findById(String id);
}
