package com.thymeleaf.thymeleafdemo.controllers;

import com.thymeleaf.thymeleafdemo.entity.Product;
import com.thymeleaf.thymeleafdemo.services.LoggedUserService;
import com.thymeleaf.thymeleafdemo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {

    private final ProductService productService;
    private LoggedUserService userService;

    public ProductsController (ProductService productService) {
        this.productService = productService;
    }

    public void setUserService (LoggedUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String viewProducts(Model model) {
        if (userService == null)
            return "redirect:/";

        model.addAttribute("username", userService.getUserName());
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public String addProduct (
            @RequestParam String name,
            @RequestParam Double price,
            Model model) {
        if (userService == null)
            return "redirect:/";

        productService.addProduct(new Product(name, price));
        model.addAttribute("username", userService.getUserName());
        model.addAttribute("products", productService.findAll());
        return "products.html";
    }
}
