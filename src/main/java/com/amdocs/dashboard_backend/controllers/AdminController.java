package com.amdocs.dashboard_backend.controllers;

import com.amdocs.dashboard_backend.models.Admin;
import com.amdocs.dashboard_backend.models.AdminRes;
import com.amdocs.dashboard_backend.services.AdminServices;
import com.couchbase.client.core.error.DocumentNotFoundException;
import jdk.jfr.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminServices adminService;
    // Error messages
    private static final String INTERNAL_SERVER_ERROR = "Internal Server Error";
    private static final String DOCUMENT_NOT_FOUND = "Document Not Found";
    public AdminController(AdminServices adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<>("Working", HttpStatus.OK);
    }
    @GetMapping("/{id}")
//    @Description(value = "...")
    public ResponseEntity<AdminRes> getAdmin(@PathVariable String id) {
        try {
            AdminRes admin = adminService.getAdminById(id);
            if (admin != null) {
                return new ResponseEntity<>(admin, HttpStatus.OK);
            } else {
//                log.error(DOCUMENT_NOT_FOUND + ": " + id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (DocumentNotFoundException e) {
//            log.error(DOCUMENT_NOT_FOUND + ": " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
//            log.error(INTERNAL_SERVER_ERROR + ": " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
