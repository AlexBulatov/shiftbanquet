package ru.cft.shiftbanquet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(description = "Запросы для работы с книгами")
public class EventController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private EventService eventService;

    @GetMapping("/events/{id}")
    @ApiOperation(value = "Добавление новой книги")
    Wrapper<Event> getEvent(@ApiParam(value = "Идентификатор пользователя") @PathVariable int id) {
        return new Wrapper<>("OK", eventRepo.findEventById(id));
    }

    @GetMapping("/events/")
    @ApiOperation(value = "Получить мероприятия")
    Event getEvents(){
        throw new NotImplementedException();
    }

    @ApiOperation(value = "Создать мероприятия")
    @PostMapping("/events/")
    Wrapper<Event> addEvent(@ApiParam(value = "Идентификатор пользователя") @RequestBody Wrapper<EventRequestPostPayload> requestWrapper){
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
