package ru.cft.shiftbanquet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.entity.Guest;
import ru.cft.shiftbanquet.entity.Wrapper;
import ru.cft.shiftbanquet.repos.EventRepo;
import ru.cft.shiftbanquet.repos.GuestRepo;
import ru.cft.shiftbanquet.repos.UserRepo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Map;

@Api(description = "Запросы для работы с гостями")
@RestController
public class GuestController {

    @Autowired
    private GuestRepo guestRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/events/{event_id}/guests/{guest_id}")
    @ApiOperation(value = "Вывести список всех гостей")
    public String getGuests() {
        throw new NotImplementedException();
    }

    @PostMapping("/events/{event_id}/guests/")
    @ApiOperation(value = "Добавить гостя")
    public Wrapper<String> addGuest(@ApiParam(value = "Идентификатор мероприятия") @PathVariable(value = "event_id") Long event_id, @RequestBody Map<String, String> login) {
        AppUser user = userRepo.findAppUserByLogin(login.get("login"));
        Event event = eventRepo.findEventById(event_id);
        Guest guest = new Guest(user, event, 0.1,0.2);

        event.getMembers().add(guest);
        eventRepo.saveAndFlush(event);
        return new Wrapper<>("OK", null);
    }

    @PutMapping("/events/{event_id}/guests/{guest_id}")
    public String editGuest() {
        throw new NotImplementedException();
    }

    @DeleteMapping("/events/{event_id}/guests/{guest_id}")
    public String deleteGuest() {
        throw new NotImplementedException();
    }
}
