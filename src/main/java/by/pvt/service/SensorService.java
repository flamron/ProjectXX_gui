package by.pvt.service;

import by.pvt.dto.DeviceDto;
import by.pvt.dto.SensorDto;
import by.pvt.dto.SensorSimpleDto;
import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import by.pvt.pojo.SensorValue;
import by.pvt.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;


@Service
public class SensorService {

    private static final Logger logger = Logger.getLogger("SearchController");

    @Autowired
    SensorRepository sensorRepository;


    @Transactional
    public Optional<SensorDto> findSensorByIds(Long deviceId, Byte sensorNumber) {
        Optional<Sensor> sensorOptional = sensorRepository.findSensorByIds(deviceId, sensorNumber);
        if (sensorOptional.isPresent()) {
            Sensor sensor = sensorOptional.get();

            //int recommendedCapacity = (int)(sensor.getValues().size() / 0.75 ) + 1;
            TreeMap<LocalDateTime, SensorValue> values = new TreeMap<>(sensor.getValues());
            //values.putAll(sensor.getValues());

            SensorDto dto = SensorDto.builder()
                    .deviceId(deviceId)
                    .name(sensor.getName())
                    .number(sensorNumber)
                    .unitOfMeasure(sensor.getUnitOfMeasure())
                    .values(values)
                    .build();
            return Optional.of(dto);
        }
        else {
            return Optional.empty();
        }
    }

}
