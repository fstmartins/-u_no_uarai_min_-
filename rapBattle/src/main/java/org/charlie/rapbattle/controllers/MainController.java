package org.charlie.rapbattle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping(method = RequestMethod.GET, value="/")
    public String home() {
        return "redirect:/main"; //VER SE ISTO FICA CORRECTO
    }
}
