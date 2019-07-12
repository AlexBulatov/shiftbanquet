package ru.cft.shiftbanquet.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.cft.shiftbanquet.entity.Event;

@Component
public class CheckAccessHelper {
    public boolean checkAccess(Event event){
        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!event.getAuthor().getLogin().equals(userLogin)){
            return false;
        } else{
            return true;
        }
    }
}
