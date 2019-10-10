package com.clementbouakil.wildCircus.repositories;

import com.clementbouakil.wildCircus.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}