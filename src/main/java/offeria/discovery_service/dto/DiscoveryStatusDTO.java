package offeria.discovery_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Data Transfer Object for discovery status.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscoveryStatusDTO {
    private String status;
    private int registeredServicesCount;
    private List<String> serviceNames;
}
