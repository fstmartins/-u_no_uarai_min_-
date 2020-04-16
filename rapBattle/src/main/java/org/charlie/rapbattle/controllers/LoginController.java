package org.charlie.rapbattle.controllers;

import org.charlie.rapbattle.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

    private UserServices userServices;

    @Autowired
    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", "","/login"})
    public String getIndexPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/register")
    public String register() {
        return "add";
    }
}
