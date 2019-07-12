package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shiftbanquet.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<AppUser, Long> {

    //AppUser findAppUserByLogin(String login);
    AppUser findAppUserByLogin(String login);

    List<AppUser> findAllByLoginIsContaining(String query);
}

