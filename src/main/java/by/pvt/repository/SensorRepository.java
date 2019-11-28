package by.pvt.repository;

import by.pvt.pojo.Device;
import by.pvt.pojo.Sensor;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class SensorRepository {

    private static final Logger logger = Logger.getLogger("SensorRepository");

    @Autowired
    SessionFactory sessionFactory;

    public Optional<Sensor> findSensorByIds(Long deviceId, Byte sensorNumber) {
        Query<Sensor> query = sessionFactory.getCurrentSession()
                .createQuery("from Sensor s where s.id.device.id = :deviceId " +
                        "and s.id.number = :sensorNumber", Sensor.class)
                .setParameter("deviceId", deviceId)
                .setParameter("sensorNumber", sensorNumber);
        Sensor sensor = null;
        try {
            sensor = query.getSingleResult();
        } catch (Exception ignore) {
        }
        return Optional.ofNullable(sensor);
    }
}
