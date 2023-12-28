package org.tapsensors.hub.sensor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;
import java.util.function.Consumer;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SensorDataSinkTest {

    @Mock
    private SensorRepository sensorRepository;
    private SensorDataSink sensorDataSink;

    @BeforeEach
    void setup(){
        sensorDataSink = new SensorDataSink(sensorRepository);
    }
    @Test
    void receiveSensorData() {
        Consumer<SensorData> sensorDataConsumer = sensorDataSink.receiveSensorData();

        SensorData sensorData = SensorDataFactory.generate();
        sensorDataConsumer.accept(sensorData);

        verify(sensorRepository).save(sensorData);
    }
}