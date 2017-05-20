package hello.controller;

import hello.User;
import hello.UserRepository;
import hello.model.MineTypes;
import hello.repository.MineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jskonst on 05.04.17.
 */
@Controller    // This means that this class is a Controller
@RequestMapping("/mine") // This means URL's start with /demo (after Application path)
public class MineController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private MineTypeRepository userRepository;

    @RequestMapping("/list") // Map ONLY GET Requests
    public @ResponseBody
    String showAll () {
        return "Saved";
    }

    @RequestMapping("/add") // Map ONLY GET Requests
    public @ResponseBody
    String add (@RequestParam(value="name", required=true) String name,
                @RequestParam(value="picture", required=false) String picture,
                @RequestParam(value="radius", required=true, defaultValue="0") String radius,
                Model model) {
        MineTypes mineType = new MineTypes();
        mineType.setTypename(name);
        mineType.setPicture(picture);
        mineType.setRadius(Float.parseFloat(radius));
        userRepository.save(mineType);
        return "Saved";
    }


}
