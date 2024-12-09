package com.unrealducks.backend.modules.user.infrastructure;

import com.unrealducks.backend.modules.user.domain.*;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId().getValue());
        entity.setUsername(user.getUsername());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRoles(user.getRoles());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        return new User(
                new UserId(entity.getId()),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRoles()
        );
    }
}
