package com.duannd.springboot.caching.controllers;

import com.duannd.springboot.caching.models.User;
import com.duannd.springboot.caching.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By ngdduan@gmail.com at 12/3/2018 3:17 PM
 */
@RestController("users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseBody
    public User get(@RequestBody User model) {
        return userService.findBy(model.getId(), model.getFirstName(), model.getLastName());
    }

}
