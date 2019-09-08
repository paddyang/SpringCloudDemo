package com.panyang.servicefeign;

import com.panyang.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "eureka-client",fallback = HelloServiceHystric.class)
public interface HelloService {


    @GetMapping("hello")
    String hi(@RequestParam(value = "name") String name);

    @GetMapping("getUser")
    User getUser(@RequestParam(value = "name") String name);

    @PostMapping(value = "addUser",consumes = "application/json")
    String addUser(@RequestBody User user);
}
