package com.unrealducks.backend.modules.user.application;
import com.unrealducks.backend.modules.user.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SearchUser {
    private final UserRepository userRepository;

    public SearchUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
