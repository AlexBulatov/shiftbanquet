package ru.cft.shiftbanquet.controller;

import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class GuestController {

    @GetMapping("api/events/{event_id}/guests/{guest_id}")
    public String getGuests() {
        throw new NotImplementedException();
    }
    
    @PostMapping("api/events/{event_id}/guests/{guest_id}")
    public String addGuest() {
        throw new NotImplementedException();
    }
    
    @PutMapping("api/events/{event_id}/guests/{guest_id}")
    public String editGuest() {
        throw new NotImplementedException();
    }
    
    @DeleteMapping("api/events/{event_id}/guests/{guest_id}")
    public String deleteGuest() {
        throw new NotImplementedException();
    }
}
