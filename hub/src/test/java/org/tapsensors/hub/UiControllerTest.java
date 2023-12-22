package org.tapsensors.hub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.tapsensors.hub.sensor.SensorRepository;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest({UiController.class, SecurityConfig.class})
class UiControllerTest {

    @MockBean
    private SensorRepository sensorRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        when(sensorRepository.findAllByOrderByIdAsc()).thenReturn(List.of());
    }
    @Test
    void dashboard_notAuthenticated_forcesLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dashboard"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    void dashboard_whenAuthenticated_returns() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dashboard"))
                .andExpect(status().isOk());
    }
}