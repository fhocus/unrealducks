package com.unrealducks.backend.modules.user.application.dto;
import com.unrealducks.backend.modules.user.domain.*;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class RegisterUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public RegisterUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(String username, String email,String rawPassword, Set<Role> roles) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("User with this username already exists");
        }

        UserId userId = new UserId(UUID.randomUUID().toString());
        String hashedPassword = passwordEncoder.encode(rawPassword);

        User user = new User(userId, username, email, hashedPassword, roles);

        userRepository.save(user);
        return user;
    }
}
