package com.clementbouakil.wildCircus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

}