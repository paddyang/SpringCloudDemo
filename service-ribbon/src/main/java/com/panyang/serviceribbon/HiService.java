package com.panyang.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name){
        return restTemplate.getForObject("http://eureka-client/hello?name="+name,String.class);
    }

    public String hiError(String name){
        return "hello,"+name+"！sorry,error!";
    }
}
