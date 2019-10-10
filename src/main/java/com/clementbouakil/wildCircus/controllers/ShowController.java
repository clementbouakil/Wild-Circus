package com.clementbouakil.wildCircus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShowController {

    @GetMapping("/shows")
    public String show() {
        return "show";
    }
    
}