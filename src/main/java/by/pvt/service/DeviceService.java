package by.pvt.service;

import by.pvt.dto.DeviceDto;
import by.pvt.dto.SensorSimpleDto;
import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import by.pvt.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;


@Service
public class DeviceService {

    private static final Logger logger = Logger.getLogger("DeviceService");

    @Autowired
    DeviceRepository deviceRepository;

    @Transactional
    public List<DeviceDto> getAllDevicesDto() {
        List<Device> devices = deviceRepository.getAllDevices();
        List<DeviceDto> dtoList = new ArrayList<>(devices.size());
        for (Device device : devices) {
            DeviceDto dto = DeviceDto.builder()
                    .id(device.getId())
                    .serialNumber(device.getSerialNumber())
                    .deviceType(device.getDeviceType())
                    .deviceModel(device.getDeviceModel())
                    //.sensorsMap(device.getSensorsMap())
                    .observationPoint(device.getObservationPoint())
                    .build();
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Transactional
    public Optional<DeviceDto> findDeviceById(Long id) {
        Optional<Device> deviceOptional = deviceRepository.findDeviceById(id);
        if (deviceOptional.isPresent()) {
            Device device = deviceOptional.get();

            DeviceDto dto = DeviceDto.builder()
                    .id(device.getId())
                    .serialNumber(device.getSerialNumber())
                    .deviceType(device.getDeviceType())
                    .deviceModel(device.getDeviceModel())
                    .sensors(getSensorSimpleDtoListFromDevice(device))
                    .observationPoint(device.getObservationPoint())
                    .build();
            return Optional.of(dto);
        }
        else {
            return Optional.empty();
        }
    }

    private List<SensorSimpleDto> getSensorSimpleDtoListFromDevice(Device device) {
        Set<Map.Entry<Byte, Sensor>> entries = device.getSensorsMap().entrySet();
        List<SensorSimpleDto> result = new ArrayList<>(entries.size());
        for (Map.Entry<Byte, Sensor> entry : entries) {
            Sensor sensor = entry.getValue();
            SensorSimpleDto dto = SensorSimpleDto.builder()
                    .name(sensor.getName())
                    .number(entry.getKey())
                    .unitOfMeasure(sensor.getUnitOfMeasure())
                    .build();
            result.add(dto);
        }
        return result;
    }

}
