package org.charlie.rapbattle.controllers;

import org.charlie.rapbattle.model.User;
import org.charlie.rapbattle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserServices(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public String getIndexPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult) {

        // Lookup user in database by e-mail
       /*User userExists = userService.findByEmail(user.getEmail());

        if (userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage",
                    "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }
*/

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else { // new user so we create user and send confirmation e-mail

            userService.saveUser(user);

            modelAndView.addObject("confirmationMessage",
                    "User registered with success");
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult) {
        User dbUser = userService.findByEmail(user.getEmail());

        if(dbUser == null || bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if(user.getPassword().equals(dbUser.getPassword())) {
           modelAndView.setViewName("user");
           return modelAndView;
        }

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
