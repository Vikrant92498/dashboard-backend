package com.amdocs.dashboard_backend.controllers;

import com.amdocs.dashboard_backend.models.AdminRes;
import com.amdocs.dashboard_backend.models.response.EmployeeDetails;
import com.amdocs.dashboard_backend.services.interfaces.AdminServices;
import com.couchbase.client.core.error.DocumentNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminServices adminService;
    // Error messages
    public AdminController(AdminServices adminService) {
        this.adminService = adminService;
    }
    @GetMapping
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<>("Working", HttpStatus.OK);
    }

    @GetMapping("/getEmployees/")
    public ResponseEntity<Page<EmployeeDetails>> getEmployees(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "10") int size
                                                            ){

        PageRequest pageable = PageRequest.of(page, size);
        Page<EmployeeDetails> employees = adminService.getEmployees(pageable);
        return ResponseEntity.ok(employees);

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
