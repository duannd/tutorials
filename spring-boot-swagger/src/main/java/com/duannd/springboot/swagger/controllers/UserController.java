package com.duannd.springboot.swagger.controllers;

import com.duannd.springboot.swagger.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By duan.nd@senseinfosys.com at 10/5/2018 4:08 PM
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable String id) {
        log.info("Get User Info");
        return new User(id);
    }

    @PostMapping
    public User add(@RequestBody User user) {
        return user;
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return user;
    }

    @GetMapping
    public List<User> findAll() {
        return new ArrayList<User>();
    }
}
