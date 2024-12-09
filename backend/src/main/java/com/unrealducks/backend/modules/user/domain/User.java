package com.unrealducks.backend.modules.user.domain;
import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private final UserId id;
    private final String username;
    private final String email;
    private final String password;
    private final Set<Role> roles;

    public User(UserId id, String username, String email, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}