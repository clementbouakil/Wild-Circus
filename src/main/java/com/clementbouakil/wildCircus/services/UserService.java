package com.clementbouakil.wildCircus.services;

import com.clementbouakil.wildCircus.entities.User;
import com.clementbouakil.wildCircus.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Value("${user.email}")
    private String email;

    @Value("${user.password}")
    private String password;

    @Value("${user.role}")
    private String role;

    @Value("${user.firstname}")
    private String firstname;

    @Value("${user.lastname}")
    private String lastname;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (userRepository.count() == 0) {
            PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            User admin = new User(email, encoder.encode(password), role, firstname, lastname);
            userRepository.save(admin);
        }
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return user;
    }

}
