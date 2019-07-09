package ru.cft.shiftbanquet.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cft.shiftbanquet.entity.Event;

public interface EventRepo extends JpaRepository<Event, Long> {

}
