package com.amdocs.dashboard_backend.services.interfaces;

import com.amdocs.dashboard_backend.models.AdminRes;
import com.amdocs.dashboard_backend.models.response.AdminDetails;
import com.amdocs.dashboard_backend.models.response.EmployeeDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminServices {
    AdminDetails getMyDetails(String token);
    AdminRes getAdminById(String id);
    Page<EmployeeDetails> getEmployees(Pageable pageable);
}
