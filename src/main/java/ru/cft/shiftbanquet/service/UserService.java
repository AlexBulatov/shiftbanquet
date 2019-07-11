package ru.cft.shiftbanquet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.repos.UserRepo;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;

    public AppUser createUser(AppUser user){
        userRepo.save(user);
        return user;
    }

    public List<AppUser> findAll(){
        return userRepo.findAll();
    }

    public AppUser findByLogin(String login){
        return userRepo.findAppUserByLogin(login).orElse(null);
    }
}
