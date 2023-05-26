package com.thymeleaf.thymeleafdemo.services;

import com.thymeleaf.thymeleafdemo.entity.Product;
import com.thymeleaf.thymeleafdemo.error.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public void addProduct (Product product) {
        products.add(product);
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findItem(String item) {
        return products.stream()
                .filter(p ->  p.name().equals(item))
                .findAny()
                .orElseThrow(() -> new ItemNotFoundException("The item is not listed"));
    }
}
