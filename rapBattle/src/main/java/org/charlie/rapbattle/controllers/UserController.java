package org.charlie.rapbattle.controllers;

import org.charlie.rapbattle.model.User;
import org.charlie.rapbattle.persistance.UserDao;
import org.charlie.rapbattle.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserServices userServices;

    @RequestMapping(method = RequestMethod.GET, value="/get")
    public String getUsers(Model model){
        model.addAttribute("users",userServices.listAll());
        return "get_users";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public String addCustomer(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }


    /**
     * Getters and Setters
     */

    public UserServices getUserServices() {
        return userServices;
    }

    @Autowired
    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

}
