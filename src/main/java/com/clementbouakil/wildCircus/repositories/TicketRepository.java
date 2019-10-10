package com.clementbouakil.wildCircus.repositories;

import com.clementbouakil.wildCircus.entities.Ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}