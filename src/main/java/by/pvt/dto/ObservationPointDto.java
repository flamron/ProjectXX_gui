package by.pvt.dto;

import by.pvt.pojo.Device;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class ObservationPointDto implements Serializable {

    private String shortName;
    private String fullName;
    private Float latitude;
    private Float longitude;
    private Float high;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Device> devices;
}
