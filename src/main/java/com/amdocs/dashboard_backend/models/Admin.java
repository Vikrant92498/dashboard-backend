package com.amdocs.dashboard_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
public class Admin {
    @Id
    private String empId;
    private String email;  // Primary Key (in case of Couchbase, it's the document ID)
    private String password;
    private String name;
    public Admin() {
        // Default constructor
    }
    public Admin(String empId,String email,String password,String name) {
        this.empId=empId;
        this.email=email;
        this.password=password;
        this.name=name;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {this.name = name;}

    public String getEmpId() { return empId;}
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

}
