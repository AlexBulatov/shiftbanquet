package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shiftbanquet.entity.AppUser;

public interface UserRepo extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByLogin(String login);
}

