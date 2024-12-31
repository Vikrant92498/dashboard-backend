package com.amdocs.dashboard_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
public class DashboardBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DashboardBackendApplication.class, args);
	}

}
