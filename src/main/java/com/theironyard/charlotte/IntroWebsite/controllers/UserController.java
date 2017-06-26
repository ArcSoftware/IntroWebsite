package com.theironyard.charlotte.IntroWebsite.controllers;

import com.theironyard.charlotte.IntroWebsite.entities.User;
import com.theironyard.charlotte.IntroWebsite.repositories.AuthorityRepo;
import com.theironyard.charlotte.IntroWebsite.repositories.UserRepo;
import com.theironyard.charlotte.IntroWebsite.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

/**
 * Created by Jake on 6/26/17.
 */
public class UserController {
    UserRepo users;
    AuthorityRepo auth;
    UserService userService;

    public UserController(UserRepo users, AuthorityRepo auth, UserService userService) {
        this.users = users;
        this.auth = auth;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            userService.createUser("admin", "1234", "1234", true);
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/new-user", method = RequestMethod.GET)
    public String newUser() {
        return "registration";
    }

    @RequestMapping(path = "/new-user", method = RequestMethod.POST)
    public String newUser(User user, String passwordConfirm) {
        userService.createUser(user.getUsername(), user.getPassword(), passwordConfirm, false);
        return "redirect:/chatroom";
    }
}
