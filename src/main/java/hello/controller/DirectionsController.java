package hello.controller;

import hello.model.Directions;
import hello.repository.DirectionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nadia on 20.05.17.
 */
@Controller
@RequestMapping

public class DirectionsController {
    @Autowired
    private DirectionsRepository directionsRepository;

    @RequestMapping("/list")
    public String exams(Model model) {
        model.addAttribute("directions", directionsRepository.findAll());
        return "directions";
    }

    @RequestMapping("/add")
    public
    @ResponseBody
    String add(@RequestParam(value = "nameDirections", required = true) String name,
               Model model) {
        Directions dir = new Directions();
        dir.setNameDirections(name);
        directionsRepository.save(dir);
        return "Saved";
    }

}
