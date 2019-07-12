package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.entity.Guest;

import java.util.List;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Long> {
    List<Guest> findGuestsByEventId(Event EventId);

    Guest findGuestByIdAndEventId (Long id, Event EventId);
}
