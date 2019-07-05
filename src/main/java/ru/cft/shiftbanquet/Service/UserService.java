package ru.cft.shiftbanquet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cft.shiftbanquet.entity.User;
import ru.cft.shiftbanquet.repos.UserRepo;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;


    public User createUser(User user){
        userRepo.save(user);
        return user;
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    public User findByLogin(String login){
        return userRepo.findUserByLogin(login);
    }
}
