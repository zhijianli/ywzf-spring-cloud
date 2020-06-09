package com.ywzf.organizationcenter.controller;

import com.ywzf.organizationcenter.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/v1")
@Slf4j
public class UserController {

    private Map<String, User> userMap = new HashMap<>();
    {
        for(int i=0;i < 5; i++) {
            User user = new User();
            user.setId(i + "");
            user.setMail("qq" + i + "@163.com");
            user.setName("Tom" + i );
            user.setRegDate(new Date());
            userMap.put(i+ "",user );
        }
    }

    @GetMapping(value = "/users/{userId}", produces = "application/json;charset=UTF-8")
    public User getUser(@PathVariable String userId) {
        User user = (User)userMap.get(userId);
        return user;
    }

    @GetMapping(value = "/usersWithSleep/{userId}", produces = "application/json;charset=UTF-8")
    public User getUserWithSleep(@PathVariable String userId, @RequestParam Long sleepTimeMillis) {
        User user = (User)userMap.get(userId);
        try {
            Thread.sleep(sleepTimeMillis);
        }
        catch(InterruptedException ex) {
            log.error("sleep exception.", ex);
        }
        return user;
    }

    @GetMapping(value = "/users/queryById", produces = "application/json;charset=UTF-8")
    public User getUserByQueryParam(@RequestParam String userId) {
        User user = (User)userMap.get(userId);
        return user;
    }

    @PostMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public User createUser() throws Exception {
        throw new Exception("create user exception");
    }

    @GetMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public Iterable<User> findAllUsers() {
        Collection<User> users = userMap.values();
        return users;
    }

    @PostMapping(value = "/keys/{key}", produces = "text/json;charset=UTF-8")
    public String setKey2(@PathVariable String key, @RequestParam String value) {

//        JSONObject jsonObj = new JSONObject();
//        jsonObj.put("key", key);
//        jsonObj.put("value", value);
//        return jsonObj.toJSONString();
        return "hello world!";
    }
}