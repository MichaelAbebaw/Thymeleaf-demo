package com.thymeleaf.thymeleafdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/")
    public String home () {
        return "index.html";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET) /* request parameter */
    public String home (
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String color,
            Model model) {
        model.addAttribute("username", name);
        model.addAttribute("color", color);
        return "index.html";
    }

    @RequestMapping(path = "/home/{color}", method = RequestMethod.GET) /* path variable */
    public String home(@PathVariable String color, Model model) {
        model.addAttribute("username", "User");
        model.addAttribute("color", color);
        return "index.html";
    }
}
