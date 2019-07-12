package ru.cft.shiftbanquet.payloads;

import lombok.Getter;
import lombok.Setter;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.entity.Event;

import java.util.List;

@Getter
@Setter
public class AppUserResponseGetPayload extends AppUser {

    List<Event> events;

    public AppUserResponseGetPayload(AppUser appUser, List<Event> events){
        this.setLogin(appUser.getLogin());
        this.setEmail(appUser.getEmail());
        this.setUsername(appUser.getUsername());
        this.setPhone(appUser.getPhone());
        this.setAvtPath(appUser.getAvtPath());
        this.events.addAll(events);
    }

}
