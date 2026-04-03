package offeria.discovery_service.repository;

import com.netflix.eureka.EurekaServerContext;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import com.netflix.discovery.shared.Application;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository layer to interact with the Eureka Registry.
 * In a discovery service, the registry acts as our primary data source.
 */
@Repository
public class DiscoveryRegistryRepository {

    /**
     * Gets all applications currently registered with Eureka.
     * @return List of Application objects.
     */
    public List<Application> findAllApplications() {
        EurekaServerContext context = EurekaServerContextHolder.getInstance().getServerContext();
        PeerAwareInstanceRegistry registry = context.getRegistry();
        return registry.getSortedApplications();
    }
    
    /**
     * In a real enterprise app, this would be an interface extending JpaRepository.
     * Since Eureka uses an in-memory registry, we wrap the Eureka Registry calls here.
     */
}
