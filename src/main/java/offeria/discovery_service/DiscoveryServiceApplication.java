package offeria.discovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Main application class for the Discovery Service (Eureka Server).
 * This service acts as a registry for all microservices in the ecosystem.
 */
@SpringBootApplication
@EnableEurekaServer // Enables the Eureka Server functionality
public class DiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceApplication.class, args);
	}

}
