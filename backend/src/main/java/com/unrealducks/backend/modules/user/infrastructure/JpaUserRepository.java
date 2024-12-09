package com.unrealducks.backend.modules.user.infrastructure;
import com.unrealducks.backend.modules.user.domain.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repository;

    public JpaUserRepository(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        repository.save(entity);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username)
                .map(UserMapper::toDomain);
    }
}
