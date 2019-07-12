package ru.cft.shiftbanquet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.entity.FriendRelation;
import ru.cft.shiftbanquet.entity.Wrapper;
import ru.cft.shiftbanquet.repos.UserRepo;
import ru.cft.shiftbanquet.service.UserService;

import java.util.List;

@Api(description = "Запросы для работы с друзями")
public class FriendsController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;


    @PostMapping("/user/{login}")
    @ApiOperation(value = "Добавить друга")
    public void addFriend(@ApiParam(value = "Логин") @PathVariable(value="login") String login) {
        // тут нужно отправить уведомление пользователю
        AppUser friend = userRepo.findAppUserByLogin(login);

        String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser user = userRepo.findAppUserByLogin(userLogin);

        if (friend != null && user != null) {

            userRepo.save(user);
        }
    }


    @GetMapping("/user/friends/")
    @ApiOperation(value = "Вывести список всех друзей")
    Wrapper<List<AppUser>> findFriends(@Param("q") String query) {
        List<AppUser> results = userRepo.findAllByLoginIsContaining(query);
        return new Wrapper<>("OK", results);
    }
}
