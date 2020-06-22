package com.feng.blog.service;

import com.feng.blog.entity.Blog;
import com.feng.blog.feignClient.UserFeignClient;
import com.feng.userApi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
private UserFeignClient userFeignClient;
    public List<Blog> list(String uid) {
//        printLog();
        return getBlogs(uid);
    }

    private void printLog() {
        List<ServiceInstance> ServiceInstances = this.discoveryClient.getInstances("user-center");
//        ServiceInstance serviceInstance = ServiceInstances.get(0);
//        System.out.print(serviceInstance.getUri());
        ServiceInstance choose = loadBalancerClient.choose("user-center");
//        System.out.println(choose.getUri());
        System.out.println(choose.getHost() + ":" + choose.getPort());
    }

    private List<Blog> getBlogs(String userId) {
        String url = "http://user-center/user/1";
      //  User user = restTemplate.getForObject(url, User.class);
      //  System.out.println(user.toString());
      //  printLog();
        System.out.println("******************************");
        User one = userFeignClient.getOne(userId);
        System.out.println(one.toString());
        List<Blog> blogList = new ArrayList<>();
        int num = 3;
        for (int i = 1; i <= num; i++) {
            Blog blog = new Blog();
            blog.setId("" + i);
            blog.setTitle("test" + i);
            blog.setContent("test" + i);
            blog.setPubUserId(userId);
            blogList.add(blog);
        }
        return blogList;
    }
}
