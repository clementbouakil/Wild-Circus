package com.clementbouakil.wildCircus.controllers;

import com.clementbouakil.wildCircus.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public String create() {
        return "redirect:/registration";
    }

}