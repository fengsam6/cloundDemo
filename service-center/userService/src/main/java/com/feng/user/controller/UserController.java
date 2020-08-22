package com.feng.user.controller;

import com.feng.user.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author feng
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public User getOne(@PathVariable("id") String id){
        User user = getUser(Long.parseLong(id));
        return user;
    }

    private User getUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setNickname("test");
        return user;
    }


}
