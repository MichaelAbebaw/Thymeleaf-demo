package com.thymeleaf.thymeleafdemo.controllers;

import com.thymeleaf.thymeleafdemo.entity.Product;
import com.thymeleaf.thymeleafdemo.error.ItemNotFoundException;
import com.thymeleaf.thymeleafdemo.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsRestController {

    private ProductService productService;

    public ProductsRestController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api")
    public ResponseEntity<List<Product>> products() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "USA")
                .header("capital", "Phoenix")
                .header("type", "technology")
                .body(productService.findAll());
    }

    @GetMapping("/api/{item}")
    public ResponseEntity<?> product(String item) {
//        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(productService.findItem(item));
//        } catch (ItemNotFoundException e) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(e.getMessage());
//        }
    }
}
