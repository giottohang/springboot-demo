package com.zmh.stuspringbootdemo.service;

import com.zmh.stuspringbootdemo.domain.User;

import java.util.Map;


public interface UserService {

    int addUser(User user);

    int deleteById(Integer id);

    int updateUser(User user);

    User getById(Integer id);

    User selectByName(String name);

    Map<String, Object> getAllQXByUserName(String username);


}
