package com.thymeleaf.thymeleafdemo.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;
    private LoggedUserService userService;

    public LoginProcessor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login() {
        boolean isTrue = (username.equals("user") || username.equals("guest")) && password.equals("password");
        if (isTrue)
            userService = new LoggedUserService(username);
        return isTrue;
    }

    public LoggedUserService getUserService() {
        return userService;
    }
}
