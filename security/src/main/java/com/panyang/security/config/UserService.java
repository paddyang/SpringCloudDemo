package com.panyang.security.config;

import com.panyang.pojo.User;
import com.panyang.pojo.UserExample;
import com.panyang.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username){
        UserExample example =new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectByExample(example).get(0);
    }
}
