package ru.test.psychology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.psychology.models.Maniac;

@Repository
public interface ManiacRepository extends JpaRepository<Maniac, Long> {

}
