package ru.test.psychology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.psychology.models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
