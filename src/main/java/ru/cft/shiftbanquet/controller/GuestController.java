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
import ru.cft.shiftbanquet.service.CheckAccessHelper;

import java.util.List;
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

    @Autowired
    private CheckAccessHelper accessHelper;

    @GetMapping("/events/{event_id}/guests/")
    @ApiOperation(value = "Вывести список всех гостей")
    public Wrapper<List<Guest>> getGuests(@PathVariable Long event_id) {
        Event event = eventRepo.findEventById(event_id);
        return new Wrapper<>("OK", guestRepo.findGuestsByEventId(event));
    }

    @GetMapping("/events/{event_id}/guests/{guest_id}")
    @ApiOperation(value = "Получить гостя мероприятия")
    public Wrapper<Guest> getGuests(@PathVariable Long event_id, @PathVariable Long guest_id) {
        Event event = eventRepo.findEventById(event_id);
        return new Wrapper<>("OK",  guestRepo.findGuestByIdAndEventId(guest_id, event));
    }

    @PostMapping("/events/{event_id}/guests/")
    @ApiOperation(value = "Добавить гостя")
    public Wrapper<String> addGuest(@ApiParam(value = "Идентификатор мероприятия") @PathVariable(value = "event_id") Long event_id, @ApiParam(value = "Логин")@RequestBody Map<String, String> login) {
        AppUser user = userRepo.findAppUserByLogin(login.get("login"));
        if(user == null){
            return new Wrapper<>("USER NOT FOUND", null);
        }
        Event event = eventRepo.findEventById(event_id);

        if (accessHelper.checkAccess(event)){
            return new Wrapper<>("NO ACCESS", null);
        }

        Guest guest = new Guest(user, event, 0.1,0.2);
        guestRepo.save(guest);
        //event.getMembers().add(guest);
        eventRepo.saveAndFlush(event);
        return new Wrapper<>("OK", null);
    }

    @PutMapping("/events/{event_id}/guests/{guest_id}")
    @ApiOperation(value = "Редактировать список гостей")
    public Wrapper<Guest> editGuest(@ApiParam(value = "Идентификатор мероприятия")@PathVariable Long event_id, @ApiParam(value = "Идентификатор гостя")@PathVariable Long guest_id, @RequestBody Wrapper<Guest> newGuest) {
        Event event = eventRepo.findEventById(event_id);
        Guest oldGuest = guestRepo.findGuestByIdAndEventId(guest_id, event);

        if (accessHelper.checkAccess(event)){
            return new Wrapper<>("NO ACCESS", null);
        }

        oldGuest.setGuest(newGuest.getData());
        guestRepo.save(oldGuest);
        return new Wrapper<>("OK", null);
    }

    @DeleteMapping("/events/{event_id}/guests/{guest_id}")
    @ApiOperation(value = "Удалить гостя из списка")
    public Wrapper<Guest> deleteGuest(@ApiParam(value = "дентификатор мероприятия")@PathVariable Long event_id, @ApiParam(value = "Идентификатор гостя")@PathVariable Long guest_id) {
        Event event = eventRepo.findEventById(event_id);
        Guest oldGuest = guestRepo.findGuestByIdAndEventId(guest_id, event);

        if (accessHelper.checkAccess(event)){
            return new Wrapper<>("NO ACCESS", null);
        }

        if (oldGuest != null) {
            guestRepo.delete(oldGuest);
            return new Wrapper<>("OK", null);
        }
        else {
            return new Wrapper<>("FAIL", null);
        }
    }
}
