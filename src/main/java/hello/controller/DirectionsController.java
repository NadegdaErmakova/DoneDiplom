package hello.controller;

import hello.model.Directions;
import hello.model.Exam;
import hello.repository.DirectionsRepository;
import hello.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nadia on 20.05.17.
 */
@Controller
@RequestMapping
public class DirectionsController {
    @Autowired
    private DirectionsRepository directionsRepository;

    @Autowired
    private ExamRepository examRepository;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/directionses")
    public String index(Model model) {
        List<Directions> directionses = (List<Directions>) directionsRepository.findAll();
        model.addAttribute("directionses", directionses);
        return "directionses";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String editRemoveEmployee(@PathVariable("id") Long directionsId, Model model) {
        directionsRepository.delete(directionsId);
        return "redirect:/directionses";
    }

    @RequestMapping(value = "addDirectionsExam/{id}", method = RequestMethod.GET)
    public String addExam(@PathVariable("id") Long directionsId, Model model){
        model.addAttribute("exam", examRepository.findAll());
        model.addAttribute("directions", directionsRepository.findOne(directionsId));
        return "addDirectionsExam";
    }

    @RequestMapping(value="/directions/{id}/exams", method=RequestMethod.GET)
    public String directionsesAddExam(@PathVariable Long id, @RequestParam Long examId, Model model) {
        Exam exam = examRepository.findOne(examId);
        Directions directions = directionsRepository.findOne(id);

        if (directions != null) {            if (!directions.hasExam(exam)) {
                directions.getExams().add(exam);
            }
            directionsRepository.save(directions);
            model.addAttribute("directions", examRepository.findOne(id));
            model.addAttribute("exams", examRepository.findAll());
            return "redirect:/directions";
        }

        return "redirect:/directions";
    }

    @RequestMapping(value = "getdirectionses", method = RequestMethod.GET)
    public @ResponseBody List<Directions> getDirections() {
        return (List<Directions>)directionsRepository.findAll();
     }

}
