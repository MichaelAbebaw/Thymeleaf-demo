package com.thymeleaf.thymeleafdemo.error;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String message) {
        super (message);
    }
}
