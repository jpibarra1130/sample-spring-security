package com.ibarra.controller;

import com.ibarra.service.UserService;
import com.ibarra.view.UserCreateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by paoloibarra on 22/8/15.
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ModelAndView getUserList() {
        ModelAndView modelAndView = new ModelAndView("user_list");
        modelAndView.addObject("users", userService.getUsers());

        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView getRegisterPage() {
        return new ModelAndView("register", "form", new UserCreateForm());
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
        return new ModelAndView("login", "error", error);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegister(@ModelAttribute("form") @Valid
                                 UserCreateForm form) {
        try {
            userService.create(form);
        } catch (Exception e) {
            LOGGER.error("Unable to save the user.", e);
            return "/register";
        }

        return "redirect:/login";
    }
}
