package com.thymeleaf.thymeleafdemo.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUserService {

    private String userName;

    public LoggedUserService(String userName) {
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }
}
