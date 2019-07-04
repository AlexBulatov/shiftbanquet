package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shiftbanquet.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

