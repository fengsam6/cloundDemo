package com.feng.blog.controller;

import com.feng.blog.entity.Blog;
import com.feng.blog.service.BlogService;
import com.feng.userApi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
   private BlogService blogService;

    @GetMapping(value = "/{userId}/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Blog> list(@PathVariable String userId) {
        return blogService.list(userId);
    }

}
