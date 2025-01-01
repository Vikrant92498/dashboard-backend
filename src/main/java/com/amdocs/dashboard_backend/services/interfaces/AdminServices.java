package com.amdocs.dashboard_backend.services.interfaces;

import com.amdocs.dashboard_backend.models.AdminRes;
import com.amdocs.dashboard_backend.models.response.EmployeeDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminServices {
    AdminRes getAdminById(String id);
    Page<EmployeeDetails> getEmployees(Pageable pageable);
}
