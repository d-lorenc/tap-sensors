package org.tapsensors.hub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.tapsensors.hub.config.BaseSecurityConfig;
import org.tapsensors.hub.sensor.SensorRepository;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityConfigTest {

    @MockBean
    private SensorRepository sensorRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setupDatabase(){
        when(sensorRepository.findAllByOrderByIdAsc()).thenReturn(List.of());
    }
    @Test
    void livelinessEndpoint_isAccessibleByAll() throws Exception {
        mockMvc.perform(get("/readyz"))
                .andExpect(status().isOk());
    }
}