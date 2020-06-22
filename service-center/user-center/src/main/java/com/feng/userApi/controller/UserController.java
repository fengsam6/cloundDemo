package com.feng.userApi.controller;

import com.feng.userApi.entity.User;
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
        User user = getUser(id);
        return user;
    }

    private User getUser(String id) {
        User user = new User();
        user.setId(id);
        user.setName("test");
        return user;
    }


}
