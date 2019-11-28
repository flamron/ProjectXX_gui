package by.pvt.repository;

import by.pvt.pojo.Device;
import by.pvt.pojo.ObservationPoint;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class ObservationPointRepository {

    private static Logger logger = Logger.getLogger("ObservationPointRepository");

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
