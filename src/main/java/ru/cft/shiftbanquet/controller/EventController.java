package ru.cft.shiftbanquet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.repos.EventRepo;
import ru.cft.shiftbanquet.repos.UserRepo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

@RestController
public class EventController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/events/{id}")
    String getEvent(@PathVariable(value = "id") int id) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        return arr.get(id);
    }

    @GetMapping("/events/")
    Event getEvents(){
        throw new NotImplementedException();
    }

    @PostMapping("/events/")
    Event addEvent(){
        throw new NotImplementedException();
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
