package com.panyang.servicefeign;

import com.panyang.pojo.User;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloServiceHystric implements HelloService{

    @Override
    public String hi(String name) {
        return "hello "+name+ "!sorry,error!";
    }

    @Override
    public User getUser(String name) {
        return new User("Hystric","",0,new Date());
    }

    @Override
    public String addUser(User user) {
        return "添加失败";
    }
}
