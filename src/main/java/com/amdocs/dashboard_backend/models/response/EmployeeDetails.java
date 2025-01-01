package com.amdocs.dashboard_backend.models.response;

public class EmployeeDetails {
    private String empId;
    private String email;
    private String name;
    public EmployeeDetails() {}

    public EmployeeDetails(String empId, String email, String name) {
        this.empId = empId;
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
