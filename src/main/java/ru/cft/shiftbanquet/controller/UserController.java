package ru.cft.shiftbanquet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.entity.User;
import ru.cft.shiftbanquet.entity.Wrapper;
import ru.cft.shiftbanquet.service.UserService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{login}")
    public Wrapper<User> getUser (@PathVariable(value="login") String login) {
        return  new Wrapper<>("OK", userService.findByLogin(login));
    }

    @PostMapping("/user/signup")
    public Wrapper<User> postSignUp(@RequestBody Wrapper<User> wrapper) {
        if(wrapper.getData() != null){
            return new Wrapper<>("OK", userService.createUser(wrapper.getData()));
        } else {
            return new Wrapper<>("DATA IS NULL", null);
        }
    }

    @PostMapping("/user/auth")
    public String postSignIn() {
        throw new NotImplementedException();
    }

}
