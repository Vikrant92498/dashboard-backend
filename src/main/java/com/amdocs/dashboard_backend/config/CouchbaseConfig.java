package com.amdocs.dashboard_backend.config;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.ClusterOptions;
import com.couchbase.client.java.env.ClusterEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchbaseConfig {

    private static final String CONNECTION_STRING = "couchbases://cb.0eegvz2hn4y3ymcx.cloud.couchbase.com"; // Replace with your Couchbase URL
    private static final String USERNAME = "admin"; // Replace with your username
    private static final String PASSWORD = "Admin@123"; // Replace with your password
    private static final String BUCKET_NAME = "amdocs_psu"; // Replace with your bucket name


    @Bean
    public Cluster cluster(ClusterEnvironment environment) {
        return Cluster.connect(
                CONNECTION_STRING,
                ClusterOptions.clusterOptions(USERNAME, PASSWORD).environment(environment)
        );
    }

    @Bean
    public ClusterEnvironment clusterEnvironment() {
        return ClusterEnvironment.builder()
                .securityConfig(securityConfig -> securityConfig.enableTls(true)) // Enable TLS
                .build();
    }

    @Bean
    public Bucket bucket(Cluster cluster) {
        return cluster.bucket(BUCKET_NAME);
    }
}
