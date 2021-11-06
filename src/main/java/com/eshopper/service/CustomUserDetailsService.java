package com.eshopper.service;

import com.eshopper.model.Users;
import com.eshopper.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.String.format;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = usersRepository.findByUsername(username);
        return optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException(
                        format("User: %s, not found", username)
                ));
    }
}
