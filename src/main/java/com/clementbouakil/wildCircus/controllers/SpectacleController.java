package com.clementbouakil.wildCircus.controllers;

import javax.validation.Valid;

import com.clementbouakil.wildCircus.entities.Spectacle;
import com.clementbouakil.wildCircus.repositories.SpectacleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpectacleController {

    @Autowired
    SpectacleRepository spectacleRepository;

    @GetMapping("/shows")
    public String show() {
        return "show";
    }

    @PostMapping("/shows")
    public String create(@Valid Spectacle show) {
        spectacleRepository.save(show);
        return "redirect:/admin/shows";
    }
    
}