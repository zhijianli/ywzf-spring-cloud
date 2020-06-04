package com.ywzf.ainurse.controller;

import com.ywzf.ainurse.client.UserServiceClient;
import com.ywzf.ainurse.domain.User;
import com.ywzf.ainurse.util.StudentConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Slf4j
public class IndexController {

    @Autowired
    UserServiceClient userServiceClient;


    @Value("${description:zy}")
    private String description;

    @Autowired
    private StudentConfig studentConfig;

    @RequestMapping("/description")
    public String testDescription() {
        System.out.println("description is : " + description);
        return description;
    }

    @RequestMapping("/config")
    public String testConfig() {
        System.out.println(studentConfig.toString());
        return studentConfig.toString();
    }

    @GetMapping(value = "/users/{userId}", produces = "application/json;charset=UTF-8")
    public User getUser(@PathVariable String userId) {
        log.error("-------------------userId = " + userId + "-----------------------");
        User user = userServiceClient.getUser(userId);
        return user;
    }
}
