package by.pvt.controller;

import by.pvt.dto.ObservationPointDto;
import by.pvt.pojo.ObservationPoint;
import by.pvt.service.ObservationPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class ObservationPointController {

    @Autowired
    ObservationPointService service;

    @RequestMapping(method = RequestMethod.GET, value = "/points")
    public String showAllDevices(Model model) {
        model.addAttribute("points", service.getAllObservationPointsDto());
        return "points";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/point/{name}")
    public String showAllDevices(@PathVariable String name, Model model) {

        Optional<ObservationPointDto> point = service.findObservationPointDtoByShortName(name);
        if (point.isPresent()) {
            model.addAttribute("point", point.get());
            return "point";
        } else {
            model.addAttribute("errorMessage", "Пункт наблюдения с именем " + name
            + " не найден!");
            return "error";
        }
    }
}
