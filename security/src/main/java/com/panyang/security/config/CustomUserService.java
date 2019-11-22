package com.panyang.security.config;

import com.panyang.pojo.User;
import com.panyang.security.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthMapper authMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (null == user){
            throw new UsernameNotFoundException("用户名不存在");
        }

        List<String> auths = authMapper.getAuths(username);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String auth : auths){
            authorities.add(new SimpleGrantedAuthority(auth));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }


}
