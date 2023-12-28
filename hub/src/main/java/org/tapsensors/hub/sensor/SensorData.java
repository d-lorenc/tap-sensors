package org.tapsensors.hub.sensor;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class SensorData {

    @Id
    private UUID id;
    private Integer temperature;
    private Integer pressure;

    public SensorData() {
        this(null, null, null);
    }

    public SensorData(UUID id, Integer temperature, Integer pressure) {
        this.id = id;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public static SensorDataBuilder builder(){
        return new SensorDataBuilder();
    }

    @JsonProperty("id")
    public UUID getId() {
        return id;
    }

    @JsonProperty("temperature")
    public Integer getTemperature() {
        return temperature;
    }

    @JsonProperty("pressure")
    public Integer getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                '}';
    }
}
