package com.amdocs.dashboard_backend.repositories.implementations;

import com.amdocs.dashboard_backend.config.CouchbaseConfig;
import com.amdocs.dashboard_backend.models.response.LoginResponse;
import com.amdocs.dashboard_backend.repositories.interfaces.AuthRepository;
import com.amdocs.dashboard_backend.utils.JwtUtil;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.json.JsonObject;
import com.couchbase.client.java.query.QueryOptions;
import com.couchbase.client.java.query.QueryResult;
import org.springframework.stereotype.Repository;

@Repository
public class AuthRepositoryImpl implements AuthRepository {
    private final Cluster cluster;
    private final Collection adminCol;
    private final Collection employeeCol;
    private final CouchbaseConfig couchbaseConfig;

    public AuthRepositoryImpl(Cluster cluster, Bucket bucket, CouchbaseConfig couchbaseConfig){
        this.cluster = cluster;
        this.adminCol = bucket.scope("dashboard").collection("admins");
        this.employeeCol = bucket.scope("dashboard").collection("employees");
        this.couchbaseConfig = couchbaseConfig;
    }
    @Override
    public LoginResponse login(String email,String password){
        try {
            // Query admin collection
            JsonObject adminResult = queryCollection(adminCol, email);
            if (adminResult != null) {
                return processLogin(adminResult, password, "admin");
            }

            // Query employee collection
            JsonObject employeeResult = queryCollection(employeeCol, email);
            if (employeeResult != null) {
                return processLogin(employeeResult, password, "employee");
            }

            // If no matching email found
            return new LoginResponse(false, "Invalid credentials", null, null);

        } catch (Exception e) {
            e.printStackTrace();
            return new LoginResponse(false, "An error occurred: " + e.getMessage(), null, null);
        }
    }
    private JsonObject queryCollection(Collection collection, String email) {
//        String query = String.format("SELECT * FROM `%s` WHERE email = $email", collection.name());
        String query = String.format(
                "SELECT * FROM `%s`.`dashboard`.`%s` WHERE email = $email",
                "amdocs_psu", collection.name()
        );
        QueryResult result = cluster.query(query, QueryOptions.queryOptions().parameters(JsonObject.create().put("email", email)));

        if (result.rowsAsObject().isEmpty()) {
            return null;
        }
        return result.rowsAsObject().get(0).getObject(collection.name());
    }
    private LoginResponse processLogin(JsonObject user, String password, String role) {
        // Validate password (Assuming passwords are hashed)
        String storedPasswordHash = user.getString("password");
        if(!password.equals(storedPasswordHash)){

            return new LoginResponse(false, "Invalid credentials", null, null);
        }
//        if (!PasswordUtils.verifyPassword(password, storedPasswordHash)) {
//            return new LoginResponse<>(false, "Invalid credentials", null, null, null);
//        }

        // Generate JWT token
        String token = JwtUtil.generateToken(user.getString("email"), user.getString("role"),user.getString("name"));
        // Return LoginResponse
        return new LoginResponse(true, "Login successful", role, token);
    }
}
