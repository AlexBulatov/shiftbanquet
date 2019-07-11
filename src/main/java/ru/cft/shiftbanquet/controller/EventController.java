package ru.cft.shiftbanquet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.entity.Event;
import ru.cft.shiftbanquet.entity.Wrapper;
import ru.cft.shiftbanquet.payloads.EventRequestPostPayload;
import ru.cft.shiftbanquet.payloads.EventResponseGetPayload;
import ru.cft.shiftbanquet.repos.EventRepo;
import ru.cft.shiftbanquet.repos.UserRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "Запросы для работы с книгами")
public class EventController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/events/{id}")
    @ApiOperation(value = "получить мероприятие по ID")
    Wrapper<EventResponseGetPayload> getEvent(@ApiParam(value = "Идентификатор пользователя") @PathVariable int id) {
        return new Wrapper<>("OK", new EventResponseGetPayload(eventRepo.findEventById(id)));
    }

    @GetMapping("/events/")
    @ApiOperation(value = "Получить все мероприятия")
    Wrapper<List<EventResponseGetPayload>> getEvents() {
        List<Event> eventList = eventRepo.findAll();
        List<EventResponseGetPayload> responseGetPayloadsList = new ArrayList<>();
        for (Event event : eventList) {
            responseGetPayloadsList.add(new EventResponseGetPayload(event));
        }
        return new Wrapper<>("OK", responseGetPayloadsList);
    }

    @ApiOperation(value = "Создать мероприятие")
    @PostMapping("/events/")
    Wrapper<Event> addEvent(@ApiParam(value = "Идентификатор пользователя") @RequestBody Wrapper<EventRequestPostPayload> requestWrapper) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();

        AppUser user = userRepo.findAppUserByLogin(userLogin);
        EventRequestPostPayload data = requestWrapper.getData();
        Event event = new Event(user, data.getTitle(), data.getAbout(), data.getLongitude(), data.getLatitude(), data.getDate());
        eventRepo.save(event);

        return new Wrapper<>("OK", null);
    }

    @PutMapping("/events/{id}")
    public Wrapper<EventRequestPostPayload> editEvent(@PathVariable(value = "id") int id,
                                                      @RequestBody Wrapper<EventRequestPostPayload> requestWrapper) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        Event event = eventRepo.findEventById(id);

        if (!event.getAuthor().getLogin().equals(userLogin)) {
            return new Wrapper<>("FAIL", null);
        } else {
            event.setEvent(requestWrapper.getData());
            eventRepo.save(event);
            return new Wrapper<>("OK", null);
        }
    }

    @DeleteMapping("/events/{id}")
    public Wrapper<Event> deleteEvent(@PathVariable(value = "id") int id) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        Event event = eventRepo.findEventById(id);

        if (!event.getAuthor().getLogin().equals(userLogin)) {
            return new Wrapper<>("FAIL", null);
        } else {
            eventRepo.delete(event);
            return new Wrapper<>("OK", null);
        }

    }
}
