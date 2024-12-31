package com.amdocs.dashboard_backend.services;

import com.amdocs.dashboard_backend.models.Admin;
import com.amdocs.dashboard_backend.models.AdminRes;

public interface AdminServices {
    AdminRes getAdminById(String id);
}
