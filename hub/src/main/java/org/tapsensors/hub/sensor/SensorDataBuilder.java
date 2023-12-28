package org.tapsensors.hub.sensor;

import java.util.UUID;

public class SensorDataBuilder {
    private UUID id = null;
    private Integer temperature = null;
    private Integer pressure = null;

    public SensorDataBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public SensorDataBuilder temperature(Integer temperature) {
        this.temperature = temperature;
        return this;
    }

    public SensorDataBuilder pressure(Integer pressure) {
        this.pressure = pressure;
        return this;
    }

    public SensorData build() {
        return new SensorData(id, temperature, pressure);
    }
}