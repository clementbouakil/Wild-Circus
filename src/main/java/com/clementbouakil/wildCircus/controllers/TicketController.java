package com.clementbouakil.wildCircus.controllers;

import java.util.List;

import com.clementbouakil.wildCircus.entities.Ticket;
import com.clementbouakil.wildCircus.entities.User;
import com.clementbouakil.wildCircus.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/order")
    public String order(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "order";
    }

    @PostMapping("/tickets")
    public String create(@ModelAttribute Ticket ticket, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        ticket.setUser(currentUser);
        ticketRepository.save(ticket);
        return "redirect:/order";
    }

}