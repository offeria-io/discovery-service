package offeria.discovery_service.controller;

import offeria.discovery_service.dto.DiscoveryStatusDTO;
import offeria.discovery_service.service.DiscoveryInfoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration/Unit test for Discovery Controller.
 * Verifies API behavior and security.
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class DiscoveryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DiscoveryInfoService discoveryInfoService;

    @Test
    @WithMockUser(username = "admin") // Simulates an authenticated user
    void getStatus_ShouldReturnStatus_WhenAuthenticated() throws Exception {
        DiscoveryStatusDTO statusDTO = DiscoveryStatusDTO.builder()
                .status("UP")
                .registeredServicesCount(1)
                .serviceNames(List.of("test-service"))
                .build();

        Mockito.when(discoveryInfoService.getDiscoveryStatus()).thenReturn(statusDTO);

        mockMvc.perform(get("/api/v1/discovery/status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("UP"))
                .andExpect(jsonPath("$.registeredServicesCount").value(1));
    }

    @Test
    void getStatus_ShouldReturnUnauthorized_WhenNotAuthenticated() throws Exception {
        mockMvc.perform(get("/api/v1/discovery/status"))
                .andExpect(status().isUnauthorized());
    }
}
