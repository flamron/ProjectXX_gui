package by.pvt.repository;

import by.pvt.pojo.Device;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeviceRepository {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    SessionFactory sessionFactory;

    public List<Device> getAllDevices() {
            return sessionFactory.getCurrentSession()
                    .createQuery("from Device ", Device.class)
                    .list();
    }

    public Optional<Device> findDeviceById(Long id) {
        Query<Device> query = sessionFactory.getCurrentSession()
                .createQuery("from Device d where d.id = :id", Device.class)
                .setParameter("id", id);
        Device device = null;
        try {
            device = query.getSingleResult();
        } catch (Exception ignore) {
        }
        return Optional.ofNullable(device);
    }
}
