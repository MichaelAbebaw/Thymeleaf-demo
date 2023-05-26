package com.thymeleaf.thymeleafdemo.controllers;

import com.thymeleaf.thymeleafdemo.services.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private ProductsController productsController;

    public LoginController(ProductsController productsController) {
        this.productsController = productsController;
    }

    @GetMapping("/")
    public String loginPage() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginAction(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        LoginProcessor loginProcessor = new LoginProcessor(username, password);
        if (loginProcessor.login()) {
            productsController.setUserService(loginProcessor.getUserService());
            return "redirect:/products";
        }

        model.addAttribute("message", "Login failed");
        return "login.html";
    }

    @GetMapping("/logout")
    public String logout(){
        productsController.setUserService(null);
        return "login.html";
    }
}
