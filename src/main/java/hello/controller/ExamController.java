package hello.controller;

import hello.model.Exam;
import hello.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jskonst on 13.05.17.
 */
@Controller    // This means that this class is a Controller
@RequestMapping("/exams") // This means URL's start with /demo (after Application path)
public class ExamController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ExamRepository examRepository;

    /*
    @RequestMapping("/list")
    public
    @ResponseBody
    Iterable<Exam> getAllUsers() {
        // This returns a JSON or XML with the users
        return examRepository.findAll();
    }
    */

    @RequestMapping("/list")
    public String users(Model model) {
        model.addAttribute("exams", examRepository.findAll());
        return "exams";
    }


    @RequestMapping("/add") // Map ONLY GET Requests
    public
    @ResponseBody
    String add(@RequestParam(value = "exname", required = true) String name,
               Model model) {
        Exam ex = new Exam();
        ex.setExamName(name);
        examRepository.save(ex);
        return "Saved";
    }



    @RequestMapping(value="/exam", method= RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("exam", new Exam());
        return "exam";
    }

    @RequestMapping(value="/exam", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Exam ex, Model model) {
        examRepository.save(ex);
        model.addAttribute("exam", ex);
        return "result";
    }

}
