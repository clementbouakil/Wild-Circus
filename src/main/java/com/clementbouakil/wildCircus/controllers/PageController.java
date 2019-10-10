package com.clementbouakil.wildCircus.controllers;

import com.clementbouakil.wildCircus.entities.User;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String forwardByRole(Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        if (currentUser.getRole().equals("ADMIN")) {
            return "forward:/admin";
        } else {
            return "forward:/";
        }
    }

}