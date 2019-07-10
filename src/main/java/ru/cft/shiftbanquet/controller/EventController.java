package ru.cft.shiftbanquet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.Service.EventService;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.entity.Wrapper;
import ru.cft.shiftbanquet.payloads.EventRequestPostPayload;
import ru.cft.shiftbanquet.repos.EventRepo;
import ru.cft.shiftbanquet.repos.UserRepo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class EventController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private EventService eventService;

    @GetMapping("/events/{id}")
    Wrapper<Event> getEvent(@PathVariable(value = "id") int id) {
        return new Wrapper<>("OK", eventRepo.findEventById(id));
    }

    @GetMapping("/events/")
    Event getEvents(){
        throw new NotImplementedException();
    }

    @PostMapping("/events/")
    Wrapper<Event> addEvent(@RequestBody Wrapper<EventRequestPostPayload> requestWrapper){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = auth.getName();

        System.out.println(userLogin);
        AppUser user = userRepo.findAppUserByLogin(requestWrapper.getData().getLogin());
        EventRequestPostPayload data = requestWrapper.getData();
        Event event = new Event(user, data.getTitle(), data.getAbout(), data.getLongitude(), data.getLatitude(), data.getDate());
        eventRepo.save(event);

        return new Wrapper<Event>("OK", null);
    }

    @PutMapping("/events/")
    Event editEvent(){
        throw new NotImplementedException();
    }

    @DeleteMapping("/events/")
    Event deleteEvent(){
        throw new NotImplementedException();
    }
}
