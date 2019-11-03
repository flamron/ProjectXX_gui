package by.pvt.dto;

import by.pvt.pojo.UnitOfMeasure;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class SensorSimpleDto implements Serializable {
    private Byte number;
    private String name;
    private UnitOfMeasure unitOfMeasure;
}
