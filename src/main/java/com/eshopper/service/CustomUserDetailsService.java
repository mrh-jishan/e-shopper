package com.eshopper.service;

import com.eshopper.model.Users;
import com.eshopper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepository.findByUsername(username);
        return optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException(
                        format("User: %s, not found", username)
                ));
    }
}
