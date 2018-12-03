package com.duannd.springboot.caching.services;

import com.duannd.springboot.caching.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created By ngdduan@gmail.com at 12/3/2018 2:50 PM
 */
@Slf4j
@Service
public class UserService {

    @Cacheable(cacheNames = "userCache", key = "{#id,#firstName,#lastName}")
    public User findBy(Integer id, String firstName, String lastName) {
        log.info("Find User by id: {}, firstName: {}, lastName: {}", id, firstName, lastName);
        return new User(id, firstName, lastName);
    }

}
