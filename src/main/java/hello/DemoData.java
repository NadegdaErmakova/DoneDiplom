package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * Created by jskonst on 17.04.17.
 */
@Controller
public class DemoData {

    @RequestMapping("/data")
    public String helloDate(Model model) {
        model.addAttribute("dayTime", new Date());
        return "data";
    }

}
