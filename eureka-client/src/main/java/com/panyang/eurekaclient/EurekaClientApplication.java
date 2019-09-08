package com.panyang.eurekaclient;

import com.panyang.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("hello")
    public String test(@RequestParam String name){
        return "你好，"+name+"！我来自端口"+port;
    }

    @RequestMapping("getUser")
    public User getUser(@RequestParam String name) {
        if ("panyang".equals(name)) {
            return new User("panyang", "", 20, new Date());
        } else {
            return null;
        }
    }

    @PostMapping("addUser")
    public String addUser(@RequestBody User user) {
        return "添加成功"+user.toString();
    }

}
