package com.clementbouakil.wildCircus.repositories;

import com.clementbouakil.wildCircus.entities.Spectacle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpectacleRepository extends JpaRepository<Spectacle, Long> {
}