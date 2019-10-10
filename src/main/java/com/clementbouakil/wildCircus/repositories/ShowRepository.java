package com.clementbouakil.wildCircus.repositories;

import com.clementbouakil.wildCircus.entities.Show;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {

}