package offeria.discovery_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import offeria.discovery_service.dto.DiscoveryStatusDTO;
import offeria.discovery_service.service.DiscoveryInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Discovery Service management APIs.
 */
@RestController
@RequestMapping("/api/v1/discovery")
@RequiredArgsConstructor
@Slf4j
public class DiscoveryController {

    private final DiscoveryInfoService discoveryInfoService;

    /**
     * Endpoint to get the current status of the Eureka Server.
     * @return ResponseEntity with discovery status details.
     */
    @GetMapping("/status")
    public ResponseEntity<DiscoveryStatusDTO> getStatus() {
        log.info("Received request for discovery status");
        return ResponseEntity.ok(discoveryInfoService.getDiscoveryStatus());
    }
}
