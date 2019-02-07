package pl.mikroblog.controller;

import com.sun.tools.javac.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.mikroblog.Service.UserService;
import pl.mikroblog.model.User;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by bartek on 07.02.2019.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView getAllUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registrationUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView registrationModel = new ModelAndView();
        Optional<User> userOptional = userService.getUserByNick(user.getNick());
        registrationModel.setViewName("registration");
        if(userOptional.isPresent()) {
            bindingResult.rejectValue("nick", "error.nick", "nick is already used");
        }else {
            if(org.springframework.util.StringUtils.containsWhitespace(user.getPassword()) || user.getPassword().length() < 5) {
                bindingResult.rejectValue("password", "error.password", "password is too short, min 5 chars");
            }else{
                userService.saveUser(user);
                registrationModel.addObject("successMessage", "User has been registered successfully");
            }
        }
        return registrationModel;
    }
}
