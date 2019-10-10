package com.clementbouakil.wildCircus.controllers;

import java.util.List;

import javax.validation.Valid;

import com.clementbouakil.wildCircus.entities.Spectacle;
import com.clementbouakil.wildCircus.repositories.SpectacleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpectacleController {

    @Autowired
    SpectacleRepository spectacleRepository;

    @GetMapping("/shows")
    public String show(Model model) {
        List<Spectacle> spectacleList = spectacleRepository.findAll();
        model.addAttribute("shows", spectacleList);
        return "show";
    }

    @PostMapping("/shows")
    public String create(@Valid Spectacle show) {
        spectacleRepository.save(show);
        return "redirect:/admin/shows";
    }

    @DeleteMapping("/shows/{id}")
    public String delete(@PathVariable Long id) {
        spectacleRepository.deleteById(id);
        return "redirect:/admin/shows";
    }
    
}