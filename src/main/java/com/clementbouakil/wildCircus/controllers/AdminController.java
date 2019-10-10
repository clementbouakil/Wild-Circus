package com.clementbouakil.wildCircus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/shows")
    public String shows() {
        return "admin/show";
    }

}