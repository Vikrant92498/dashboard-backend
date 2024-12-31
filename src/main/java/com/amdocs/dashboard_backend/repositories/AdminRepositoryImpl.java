package com.amdocs.dashboard_backend.repositories;

import com.amdocs.dashboard_backend.config.CouchbaseConfig;
import com.amdocs.dashboard_backend.models.Admin;
import com.amdocs.dashboard_backend.models.AdminRes;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryImpl implements AdminRepository{
    private final Cluster cluster;
    private final Collection adminCol;
    private final CouchbaseConfig couchbaseConfig;

    public AdminRepositoryImpl(Cluster cluster, Bucket bucket, CouchbaseConfig couchbaseConfig) {
        this.cluster = cluster;
        this.adminCol = bucket.scope("dashboard").collection("employees");
        this.couchbaseConfig = couchbaseConfig;
    }

    @Override
    public AdminRes findById(String id) {
        try {
            var result = adminCol.get(id);
            var admin = result.contentAs(AdminRes.class);
            admin.setEmpId(id);
            return admin;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching Admin with ID: " + id, e);
        }
    }
}
