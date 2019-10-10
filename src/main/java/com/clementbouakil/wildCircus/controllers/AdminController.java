package com.clementbouakil.wildCircus.controllers;

import java.util.List;

import com.clementbouakil.wildCircus.entities.Spectacle;
import com.clementbouakil.wildCircus.repositories.SpectacleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @Autowired
    SpectacleRepository spectacleRepository;

    @GetMapping("/admin/shows")
    public String shows(Model model) {
        List<Spectacle> spectacleList = spectacleRepository.findAll();
        model.addAttribute("shows", spectacleList);
        return "admin/show";
    }

}