package by.pvt.dto;

import by.pvt.pojo.DeviceModel;
import by.pvt.pojo.DeviceType;
import by.pvt.pojo.ObservationPoint;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DeviceDto {
    private Long id;
    private String serialNumber;
    private DeviceType deviceType;
    private DeviceModel deviceModel;
    private List<SensorSimpleDto> sensors;
    private ObservationPoint observationPoint;
}
