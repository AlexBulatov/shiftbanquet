package ru.cft.shiftbanquet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.repos.UserRepo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/api/events/{id}")
    String getEvent(@PathVariable(value = "id") int id) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("1");
        arr.add("2");
        arr.add("3");
        return arr.get(id);
    }

    @GetMapping("/api/events/")
    Event getEvents(){
        throw new NotImplementedException();
    }

    @PostMapping("/api/events/")
    Event addEvent(){
        throw new NotImplementedException();
    }

    @PutMapping("/api/events/")
    Event editEvent(){
        throw new NotImplementedException();
    }

    @DeleteMapping("/api/events/")
    Event deleteEvent(){
        throw new NotImplementedException();
    }

}
