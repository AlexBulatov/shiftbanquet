package ru.cft.shiftbanquet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.repos.EventRepo;

@Service
public class EventService {

    @Autowired
    private EventRepo eventRepo;

    public Event createEvent(Event event) {
        eventRepo.save(event);
        return event;
    }
}
