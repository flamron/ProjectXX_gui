package by.pvt.repository;

import by.pvt.pojo.Device;
import by.pvt.pojo.ObservationPoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ObservationPointRepository {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    SessionFactory sessionFactory;

    public List<ObservationPoint> getAllObservationPoints() {
            return sessionFactory.getCurrentSession()
                    .createQuery("from ObservationPoint ", ObservationPoint.class)
                    .list();

    }

    public Optional<ObservationPoint> findObservationPointByShortName(String shortName) {
        Query<ObservationPoint> p = sessionFactory.getCurrentSession()
                .createQuery("from ObservationPoint op where op.shortName = :shortName",
                        ObservationPoint.class)
                .setParameter("shortName", shortName);
        ObservationPoint result = null;
        try {
            result = p.getSingleResult();
        }
        catch (Exception ignored) {
        }

        return Optional.ofNullable(result);
    }
}
