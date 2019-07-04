package ru.cft.shiftbanquet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.shiftbanquet.entity.User;
import ru.cft.shiftbanquet.repos.UserRepo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("api/user/{login}")
    public User getUser (@PathVariable(value="login") String login) {
        return null;
    }

    @PostMapping("api/user/signup")
    public String postSignUp() {
        throw new NotImplementedException();
    }

    @PostMapping("api/user/signin")
    public String postSignIn() {
        throw new NotImplementedException();
    }

}
