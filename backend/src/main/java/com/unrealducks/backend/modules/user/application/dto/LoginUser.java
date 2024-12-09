package com.unrealducks.backend.modules.user.application.dto;
import com.unrealducks.backend.modules.user.domain.User;
import com.unrealducks.backend.modules.user.domain.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginUser {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void execute(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

    }
}
