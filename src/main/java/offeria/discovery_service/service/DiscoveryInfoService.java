package offeria.discovery_service.service;

import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import offeria.discovery_service.dto.DiscoveryStatusDTO;
import offeria.discovery_service.repository.DiscoveryRegistryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for retrieving Discovery Service status.
 * Interacts with Eureka Registry Repository to fetch registered applications.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DiscoveryInfoService {

    private final DiscoveryRegistryRepository discoveryRegistryRepository;

    /**
     * Retrieves the current status of the Eureka registry.
     * @return DiscoveryStatusDTO containing registry metadata.
     */
    public DiscoveryStatusDTO getDiscoveryStatus() {
        log.info("Fetching Eureka discovery status");
        
        List<Application> applications = discoveryRegistryRepository.findAllApplications();
        
        return DiscoveryStatusDTO.builder()
                .status("UP")
                .registeredServicesCount(applications.size())
                .serviceNames(applications.stream()
                        .map(app -> app.getName().toLowerCase())
                        .collect(Collectors.toList()))
                .build();
    }
}
