package org.charlie.rapbattle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping(method = RequestMethod.GET, path={"/", ""})
    public String home() {
        return "mainpage"; //VER SE ISTO FICA CORRECTO
    }

    @RequestMapping(method = RequestMethod.GET, value="room/{id}")
    public String room(@PathVariable Integer id) {
        return "room" + id;
    }
}


