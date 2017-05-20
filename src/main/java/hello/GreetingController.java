package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Created by jskonst on 14.03.17.
 */
@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/calc")
    public String calculate(@RequestParam(value="a", required=false, defaultValue="0") String firstParam,
                            @RequestParam(value="b", required=false, defaultValue="0") String secondParam,
                            Model model) {
        int summ = Integer.parseInt(firstParam) + Integer.parseInt(secondParam);
        model.addAttribute("summ", summ);
        return "templsumm";
    }

    @RequestMapping("/user")
    public String calculate(@RequestParam(value="name", required=false, defaultValue="nope") String usr,Model model) {

        model.addAttribute("mdl", userRepository.findAll());

        return "users";
    }


}
