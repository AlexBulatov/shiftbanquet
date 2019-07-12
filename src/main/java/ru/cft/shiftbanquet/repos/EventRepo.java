package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.entity.Event;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {
    Event findEventById(long id);

    List<Event> findAllByAuthor(AppUser user);

}
