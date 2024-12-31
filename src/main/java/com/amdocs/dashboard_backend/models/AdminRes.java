package com.amdocs.dashboard_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminRes {
    private String empId;
    private String email;  // Primary Key (in case of Couchbase, it's the document ID)
    private String name;
    public AdminRes() {
        // Default constructor
    }
    public AdminRes(String empId,String email,String name) {
        this.empId=empId;
        this.email=email;
        this.name=name;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {this.name = name;}

    public String getEmpId() { return empId;}
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
}
