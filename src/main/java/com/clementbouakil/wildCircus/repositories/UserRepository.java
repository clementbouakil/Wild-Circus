package com.clementbouakil.wildCircus.repositories;

import com.clementbouakil.wildCircus.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}