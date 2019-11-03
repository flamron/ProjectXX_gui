package by.pvt.controller;

import by.pvt.dto.DeviceDto;
import by.pvt.dto.SensorDto;
import by.pvt.service.DeviceService;
import by.pvt.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class SensorController {

    @Autowired
    SensorService sensorService;

    @RequestMapping(method = RequestMethod.GET, value = "/sensor/{deviceId}/{sensorNumber}")
    public String showAllDevices(@PathVariable Long deviceId,
                                 @PathVariable Byte sensorNumber,
                                 Model model) {
        Optional<SensorDto> o = sensorService.findSensorByIds(deviceId, sensorNumber);
        if (o.isPresent()) {
            model.addAttribute("sensor", o.get());
            return "sensor";
        } else {
            model.addAttribute("errorMessage", "Сенсор не найден!");
            return "error";
        }
    }
}
