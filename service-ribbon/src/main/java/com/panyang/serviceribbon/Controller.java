package com.panyang.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private HiService hiService;

    @RequestMapping("hi")
    public String test(@RequestParam String name){
        return hiService.hi(name);
    }
}
