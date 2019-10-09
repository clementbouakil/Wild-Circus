package com.clementbouakil.wildCircus.services;

import com.clementbouakil.wildCircus.entities.User;
import com.clementbouakil.wildCircus.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Value("${user.username}")
    private String username;

    @Value("${user.password}")
    private String password;

    @Value("${user.role}")
    private String role;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (userRepository.count() == 0) {
            User admin = new User();
            userRepository.save(admin);
        }

        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }

}
