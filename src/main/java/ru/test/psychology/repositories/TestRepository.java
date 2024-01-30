package ru.test.psychology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.psychology.models.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
