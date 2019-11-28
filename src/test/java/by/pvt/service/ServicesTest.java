package by.pvt.service;

import by.pvt.TestHelloWebMvcConfiguration;
import by.pvt.dto.DeviceDto;
import by.pvt.dto.ObservationPointDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@ContextConfiguration(classes = TestHelloWebMvcConfiguration.class)
@WebAppConfiguration
@RunWith(SpringRunner.class)
public class ServicesTest {

    @Autowired
    DeviceService deviceService;

    @Test
    public void getAllDevicesDto() {
        assertNotNull(deviceService);
        List<DeviceDto> allDevicesDto = deviceService.getAllDevicesDto();
        assertEquals(32, allDevicesDto.size());
        DeviceDto deviceDto = allDevicesDto.get(0);
        Long id = deviceDto.getId();

        Optional<DeviceDto> oDeviceById = deviceService.findDeviceById(id);
        assertTrue(oDeviceById.isPresent());
        DeviceDto deviceById = oDeviceById.get();
        assertEquals(deviceDto.getSerialNumber(), deviceById.getSerialNumber());
    }

    @Autowired
    ObservationPointService observationPointService;

    @Test
    public void getAllObservationPointsDtoTest() {
        List<ObservationPointDto> allObservationPointsDto = observationPointService.getAllObservationPointsDto();
        assertEquals(9, allObservationPointsDto.size());
        ObservationPointDto observationPointDto = allObservationPointsDto.get(0);
        assertEquals( 3, observationPointDto.getShortName().length());
    }


}