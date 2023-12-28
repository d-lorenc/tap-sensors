package org.tapsensors.hub.sensor;

import java.util.Random;
import java.util.UUID;

public class SensorDataFactory {
    public static SensorData generate() {
        Random random = new Random();
        return SensorData.builder()
                .temperature(random.nextInt())
                .pressure(random.nextInt())
                .id(UUID.randomUUID())
                .build();
    }
}
