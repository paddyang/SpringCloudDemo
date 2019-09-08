package com.panyang.servicefeign;

import com.panyang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("hi")
    public String hi(@RequestParam String name){
        return helloService.hi(name);
    }

    @RequestMapping("getUser")
    public String getUser(@RequestParam String name){
        return helloService.getUser(name).toString();
    }

    @RequestMapping("addUser")
    public String getUser(@RequestBody User user){
        return helloService.addUser(user);
    }
}
