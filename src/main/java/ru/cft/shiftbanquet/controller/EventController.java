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
import ru.cft.shiftbanquet.repos.EventRepo;
import ru.cft.shiftbanquet.repos.UserRepo;

import java.util.List;

@RestController
@Api(description = "Запросы для работы с мероприятиями")
public class EventController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/events/{id}")
    @ApiOperation(value = "получить мероприятие по ID")
    Wrapper<Event> getEvent(@ApiParam(value = "Идентификатор мероприятия") @PathVariable long id) {
        return new Wrapper<>("OK", eventRepo.findEventById(id));
    }

    @GetMapping("/events/")
    @ApiOperation(value = "Получить все мероприятия")
    Wrapper<List<Event>> getEvents() {
        List<Event> eventList = eventRepo.findAll();
        return new Wrapper<>("OK", eventList);
    }

    @GetMapping("/events/l/")
    @ApiOperation(value = "Получить мероприятия")
    Wrapper<List<Event>> getEventsInLimit(@ApiParam(value = "Предел")@RequestParam("limit") int limit, @ApiParam(value = "Смещение")@RequestParam("offset") int offset) {
        List<Event> eventList = eventRepo.findAll().subList(offset, offset + limit);
        return new Wrapper<>("OK", eventList);
    }


    @PostMapping("/events/")
    @ApiOperation(value = "Создать мероприятие")
    Wrapper<Event> addEvent(@ApiParam(value = "Сущность события") @RequestBody Wrapper<EventRequestPostPayload> requestWrapper) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser user = userRepo.findAppUserByLogin(userLogin);

        EventRequestPostPayload data = requestWrapper.getData();

        if (user == null) {
            return new Wrapper<>("USER NOT FOUND(INVALID TOKEN)", null);
        } else{
            Event event = new Event(user, data.getTitle(), data.getAbout(), data.getLongitude(), data.getLatitude(), data.getDate());
            eventRepo.save(event);
            return new Wrapper<>("OK", event);
        }
    }


    @PutMapping("/events/{id}")
    @ApiOperation(value = "Редактировать мероприятие")
    public Wrapper<EventRequestPostPayload> editEvent(@ApiParam(value = "Идентификатор мероприятия")@PathVariable(value = "id") int id,
                                                      @ApiParam(value = "Сущность события")@RequestBody Wrapper<EventRequestPostPayload> requestWrapper) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        Event event = eventRepo.findEventById(id);

        if (!event.getAuthor().getLogin().equals(userLogin)) {
            return new Wrapper<>("NO ACCESS", null);
        } else {
            event.setEvent(requestWrapper.getData());
            eventRepo.save(event);
            return new Wrapper<>("OK", null);
        }
    }


    @DeleteMapping("/events/{id}")
    @ApiOperation(value = "Удалить мероприятие")
    public Wrapper<Event> deleteEvent(@ApiParam(value = "Идентификатор меропрития")@PathVariable(value = "id") int id) {
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        Event event = eventRepo.findEventById(id);

        if (!event.getAuthor().getLogin().equals(userLogin)) {
            return new Wrapper<>("NO ACCESS", null);
        } else {
            eventRepo.delete(event);
            return new Wrapper<>("OK", null);
        }
    }
}
