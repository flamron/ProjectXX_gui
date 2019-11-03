package by.pvt.service;

import by.pvt.dto.DeviceDto;
import by.pvt.dto.ObservationPointDto;
import by.pvt.pojo.Device;
import by.pvt.pojo.ObservationPoint;
import by.pvt.repository.ObservationPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class ObservationPointService {

    @Autowired
    ObservationPointRepository repository;

    @Transactional
    public List<ObservationPointDto> getAllObservationPointsDto() {
        List<ObservationPoint> points = repository.getAllObservationPoints();
        List<ObservationPointDto> dtoPoints = new ArrayList<>(points.size());
        for (ObservationPoint point : points) {
            ObservationPointDto dto = ObservationPointDto.builder()
                    .shortName(point.getShortName())
                    .fullName(point.getFullName())
                    .latitude(point.getLatitude())
                    .longitude(point.getLongitude())
                    .high(point.getHigh())
                    .build();
            dtoPoints.add(dto);
        }
        return dtoPoints;
    }

    @Transactional
    public Optional<ObservationPointDto> findObservationPointDtoByShortName(String shortName) {

        Optional<ObservationPoint> pointOptional = repository.findObservationPointByShortName(shortName);

        if (pointOptional.isPresent()) {
            ObservationPoint point = pointOptional.get();
            ObservationPointDto dto = ObservationPointDto.builder()
                    .shortName(point.getShortName())
                    .fullName(point.getFullName())
                    .latitude(point.getLatitude())
                    .longitude(point.getLongitude())
                    .high(point.getHigh())
                    .devices(new HashSet<Device>(point.getDevices()))
                    .build();
            return Optional.of(dto);
        } else {
            return Optional.empty();
        }
    }
}
