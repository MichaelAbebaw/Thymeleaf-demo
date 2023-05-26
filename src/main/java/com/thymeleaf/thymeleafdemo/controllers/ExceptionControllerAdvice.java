package com.thymeleaf.thymeleafdemo.controllers;

import com.thymeleaf.thymeleafdemo.error.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> itemNotFoundExceptionHandler(ItemNotFoundException e) {
        return ResponseEntity
                .badRequest()
                .body(e.getMessage());
    }
}
