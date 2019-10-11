package com.clementbouakil.wildCircus.controllers;

import java.util.List;

import com.clementbouakil.wildCircus.entities.Spectacle;
import com.clementbouakil.wildCircus.entities.Ticket;
import com.clementbouakil.wildCircus.entities.User;
import com.clementbouakil.wildCircus.repositories.SpectacleRepository;
import com.clementbouakil.wildCircus.repositories.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    SpectacleRepository spectacleRepository;

    @GetMapping("/tickets")
    public String order(Model model) {
        List<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "order";
    }

    @PostMapping("/tickets")
    public String create(@ModelAttribute Ticket ticket, Authentication authentication, Long showId) {
        Spectacle spectacle = spectacleRepository.getOne(showId);
        User currentUser = (User) authentication.getPrincipal();
        ticket.setUser(currentUser);
        ticket.setPrice(spectacle.getPrice());
        ticket.setQuantity(ticket.getQuantity() + 1);
        ticket.setSpectacle(spectacle);
        ticketRepository.save(ticket);
        return "redirect:/tickets";
    }

    @DeleteMapping("/tickets/{id}")
    public String delete(@PathVariable Long id) {
        ticketRepository.deleteById(id);
        return "redirect:/tickets";
    }

    @PutMapping("/tickets/{id}")
    public String update(@PathVariable Long id) {
        Ticket ticket = ticketRepository.getOne(id);
        ticket.setQuantity(ticket.getQuantity() + 1);
        ticketRepository.save(ticket);
        return "redirect:/tickets";
    }

}