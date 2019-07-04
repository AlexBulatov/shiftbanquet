package ru.cft.shiftbanquet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cft.shiftbanquet.entity.User;
import ru.cft.shiftbanquet.repos.UserRepo;


@RestController
@RequestMapping("/")
public class test {

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    private User findUser(@PathVariable("id") String id){
        return userRepo.findByLogin(id);
    }

//    @PostMapping("/create")
//    private User createUser(@RequestBody() )
}
