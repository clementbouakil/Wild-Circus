package com.clementbouakil.wildCircus.controllers;

import com.clementbouakil.wildCircus.entities.Show;
import com.clementbouakil.wildCircus.entities.User;
import com.clementbouakil.wildCircus.repositories.ShowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShowController {

    @Autowired
    ShowRepository showRepository;

    @GetMapping("/shows")
    public String forwardByRole(Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        if (currentUser.getRole().equals("ADMIN")) {
            return "forward:/admin/shows";
        } else {
            return "show";
        }
    }

    @PostMapping("/shows")
    public String create(@ModelAttribute Show show) {
        showRepository.save(show);
        return "redirect:/admin/shows";
    }

}