package by.pvt.controller;

import by.pvt.dto.DeviceDto;
import by.pvt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(method = RequestMethod.GET, value = "/devices")
    public String showAllDevices(Model model) {
        model.addAttribute("devices", deviceService.getAllDevicesDto());
        return "devices";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/device/{id}")
    public String showAllDevices(@PathVariable Long id, Model model) {
        Optional<DeviceDto> o = deviceService.findDeviceById(id);
        if (o.isPresent()) {
            model.addAttribute("device", o.get());
            return "device";
        } else {
            model.addAttribute("errorMessage", "Прибор с id=" + id
                    + " не найден!");
            return "error";
        }
    }
}
