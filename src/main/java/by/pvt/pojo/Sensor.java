package by.pvt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@Entity
public class Sensor implements Serializable {

    @EmbeddedId
    SensorId id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "measure_unit_id")
    private UnitOfMeasure unitOfMeasure;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "id.sensor", fetch = FetchType.LAZY)
    @MapKey(name = "id.localDateTime")
    private Map<LocalDateTime, SensorValue> values = new HashMap<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class SensorId implements Serializable {
        @Column
        private Byte number;

        @ToString.Exclude
        @ManyToOne
        private Device device;
    }

}
