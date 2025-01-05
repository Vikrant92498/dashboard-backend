package com.amdocs.dashboard_backend.repositories.implementations;

import com.amdocs.dashboard_backend.config.CouchbaseConfig;
import com.amdocs.dashboard_backend.models.AdminRes;
import com.amdocs.dashboard_backend.models.response.AdminDetails;
import com.amdocs.dashboard_backend.models.response.EmployeeDetails;
import com.amdocs.dashboard_backend.repositories.interfaces.AdminRepository;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
    private final Cluster cluster;
    private final Collection employeeCol;
    private final Collection adminCol;
    private final CouchbaseConfig couchbaseConfig;

    public AdminRepositoryImpl(Cluster cluster, Bucket bucket, CouchbaseConfig couchbaseConfig) {
        this.cluster = cluster;
        this.adminCol = bucket.scope("dashboard").collection("admins");
        this.employeeCol = bucket.scope("dashboard").collection("employees");
        this.couchbaseConfig = couchbaseConfig;
    }

    @Override
    public AdminDetails getMyDetails(String email){
        String query = String.format(
                "SELECT * FROM `%s`.`dashboard`.`%s` WHERE email = $email",
                "amdocs_psu", adminCol.name()
        );
        QueryResult result = cluster.query(query, QueryOptions.queryOptions().parameters(JsonObject.create().put("email", email)));

        if (result.rowsAsObject().isEmpty()) {
            return null;
        }
        JsonObject adminInfo = result.rowsAsObject().get(0).getObject(adminCol.name());
        AdminDetails adminDetails = new AdminDetails(adminInfo.getString("empId"),adminInfo.getString("email"),adminInfo.getString("name"));
        return adminDetails;
    }

    @Override
    public AdminRes findById(String id) {
        try {
            var result = employeeCol.get(id);
            var admin = result.contentAs(AdminRes.class);
            admin.setEmpId(id);
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching Admin with ID: " + id, e);
        }
    }
    @Override
    public Page<EmployeeDetails> findEmployees(Pageable pageable) {
        try {
            String query = String.format(
                    "SELECT  employees.* " +
                            "FROM `amdocs_psu`.`dashboard`.`employees` " +
                            "ORDER BY employees.name " + // Replace `name` with the field you'd like to order by
                            "LIMIT %d OFFSET %d",
                    pageable.getPageSize(), pageable.getOffset()
            );

            QueryResult result = cluster.query(query);

            // Map query result to EmployeeDetails
            List<EmployeeDetails> employees = result.rowsAsObject().stream()
                    .map(row -> {
                        EmployeeDetails employee = new EmployeeDetails();
                        employee.setEmpId(row.getString("empId"));
                        employee.setName(row.getString("name"));
                        employee.setEmail(row.getString("email"));
                        return employee;
                    })
                    .collect(Collectors.toList());

            // Fetch total count of employees
            String countQuery = "SELECT COUNT(*) AS total FROM `amdocs_psu`.`dashboard`.`employees`";
            int total =cluster.query(countQuery).rowsAsObject().get(0).getInt("total");

            // Return the result as a Page
            return new PageImpl<>(employees, pageable, total);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching employees with pagination", e);
        }
    }
}
