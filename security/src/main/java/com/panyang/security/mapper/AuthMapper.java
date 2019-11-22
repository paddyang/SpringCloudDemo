package com.panyang.security.mapper;

import java.util.List;

public interface AuthMapper {

    List<String> getAuths(String username);
}