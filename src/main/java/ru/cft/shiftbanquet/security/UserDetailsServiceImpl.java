package ru.cft.shiftbanquet.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.cft.shiftbanquet.entity.AppUser;
import ru.cft.shiftbanquet.service.UserService;

import static java.util.Collections.emptyList;

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser user = userService.findByLogin(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        return new User(user.getUsername(), user.getPassword(), emptyList());
    }
}
