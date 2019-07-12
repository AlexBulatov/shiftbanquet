package ru.cft.shiftbanquet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.entity.Wrapper;
import ru.cft.shiftbanquet.service.UserService;

@Api(description = "Запросы для работы с пользователем")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/user/signup")
    @ApiOperation(value = "Регистрация нового пользователя")
    public Wrapper<AppUser> postSignUp(@RequestBody Wrapper<AppUser> wrapper) {
        if(wrapper.getData() != null){
            AppUser user = wrapper.getData();
            if(userService.findByLogin(user.getLogin()) != null){
                return new Wrapper<>("USER WITH THIS LOGIN ALREADY EXISTS", null);
            } else {
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                return new Wrapper<>("OK", userService.createUser(wrapper.getData()));
            }
        } else {
            return new Wrapper<>("DATA IS NULL", null);
        }
    }

    @GetMapping("/user/{login}")
    @ApiOperation(value = "Вход в аккаунт пользователя")
    public Wrapper<AppUser> getUser (@ApiParam(value = "Логин") @PathVariable(value="login") String login) {
        AppUser user = userService.findByLogin(login);
        if(user == null){
            return  new Wrapper<>("USER NOT FOUND", null);
        } else
            return  new Wrapper<>("OK", user);
    }

}
