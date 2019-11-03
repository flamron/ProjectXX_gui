package by.pvt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sensor_value")
public class SensorValue implements Serializable {

    @EmbeddedId
    private SensorValueId id;

    @Column
    private Double value;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class SensorValueId implements Serializable {
        @ToString.Exclude
        @ManyToOne
        private Sensor sensor;

        @Column(name = "local_date_time")
        private LocalDateTime localDateTime;

    }

}
