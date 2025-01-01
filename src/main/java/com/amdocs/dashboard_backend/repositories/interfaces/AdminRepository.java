package com.amdocs.dashboard_backend.repositories.interfaces;

import com.amdocs.dashboard_backend.models.AdminRes;
import com.amdocs.dashboard_backend.models.response.EmployeeDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminRepository {
    AdminRes findById(String id);
    Page<EmployeeDetails> findEmployees(Pageable pageable);
}
