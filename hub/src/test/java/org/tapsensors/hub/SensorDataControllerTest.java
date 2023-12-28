package org.tapsensors.hub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.tapsensors.hub.sensor.SensorData;
import org.tapsensors.hub.sensor.SensorDataFactory;
import org.tapsensors.hub.sensor.SensorRepository;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SensorDataControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SensorRepository sensorRepository;
    @Test
    void getSensorData_notAuthenticated_401() throws Exception {
        mockMvc.perform(get("/api/sensor-data"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    @WithMockUser
    void getSensorData_authenticated_returnsData() throws Exception {
        SensorData sensorData = SensorDataFactory.generate();

        when(sensorRepository.findAllByOrderByIdAsc())
                .thenReturn(List.of(sensorData));

        mockMvc.perform(get("/api/sensor-data"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.data[0].temperature").value(sensorData.getTemperature()))
                .andExpect(jsonPath("$.data[0].pressure").value(sensorData.getPressure()))
                .andExpect(jsonPath("$.data[0].id").value(sensorData.getId().toString()));

        verify(sensorRepository).findAllByOrderByIdAsc();
        verifyNoMoreInteractions(sensorRepository);
    }
}