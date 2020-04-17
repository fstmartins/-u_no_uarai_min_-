package org.charlie.rapbattle.controllers;

import org.charlie.rapbattle.model.User;
import org.charlie.rapbattle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserServices(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", "", "/login"})
    public String getIndexPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public String register(Model model) {
        model.addAttribute("user",new User());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult) {


       User userExists = userService.findByEmail(user.getEmail());

        if (userExists != null) {
            modelAndView.setViewName("register");
            modelAndView.addObject("noMatchPassword",
                    "Yo broda! We already have this email, choose other!");
        }else if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
            modelAndView.addObject("noMatchPassword",
                    "Yo broda! The form has errors! You know what I mean?");
        }else if(!user.getPassword().equals(user.getConfirmPassword())) {
            modelAndView.addObject("noMatchPassword",
                    "Yo broda! Your passwords don't match!");
            modelAndView.setViewName("register");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("infoMessage",
                    "Yo broda! You are in, just like last night ehehe ;)!");
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/doLogin")
    public ModelAndView login(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult) {
        User dbUser = userService.findByEmail(user.getEmail());

        if(dbUser == null) {
            modelAndView.addObject("infoMessage",
                    "Yo broda this email doesn't exist, register please");
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if(user.getPassword().equals(dbUser.getPassword())) {
           modelAndView.setViewName("mainpage");
           return modelAndView;
        }

        modelAndView.addObject("infoMessage",
                "Yo broda! Are u tryin to hack someone? Wrong password");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/getPage"})
    public String getPage(@ModelAttribute("user") User user) {

        if(user.getEmail().equals("jaime_reis18@outlook.pt")){
            return "add";
        }
        return "login";
    }
}
