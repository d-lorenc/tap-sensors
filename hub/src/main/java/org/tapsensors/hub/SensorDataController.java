package org.tapsensors.hub;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tapsensors.hub.sensor.SensorData;
import org.tapsensors.hub.sensor.SensorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/sensor-data")
public class SensorDataController {
    private final SensorRepository sensorRepository;

    public SensorDataController(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    static class SensorDataDTO {
        private List<SensorData> data;
        public SensorDataDTO(List<SensorData> data){
            this.data = data;
        }
        @JsonProperty("data")
        public List<SensorData> getData(){
            return this.data;
        }
    }
    @GetMapping
    public SensorDataDTO list(){
        List<SensorData> sensorData = sensorRepository.findAllByOrderByIdAsc();
        return new SensorDataDTO(sensorData);
    }
}
