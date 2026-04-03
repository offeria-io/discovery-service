package offeria.discovery_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Basic context load test to ensure Spring application context initializes correctly.
 */
@SpringBootTest
@ActiveProfiles("dev") // Use dev profile for testing
class DiscoveryServiceApplicationTests {

	@Test
	void contextLoads() {
		// Verifies that the application context starts up without errors
	}

}
