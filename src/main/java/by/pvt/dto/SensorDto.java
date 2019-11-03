package by.pvt.dto;

import by.pvt.pojo.SensorValue;
import by.pvt.pojo.UnitOfMeasure;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class SensorDto implements Serializable {

    private Long deviceId;
    private Byte number;
    private String name;
    private UnitOfMeasure unitOfMeasure;
    private Map<LocalDateTime, SensorValue> values;
}
