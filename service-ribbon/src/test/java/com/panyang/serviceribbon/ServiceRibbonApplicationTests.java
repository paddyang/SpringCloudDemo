package com.panyang.serviceribbon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceRibbonApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
        String s="123456789";
        System.out.println(s.length());
        String substring = s.substring(5, 9);
        System.out.println(substring);
    }
}
