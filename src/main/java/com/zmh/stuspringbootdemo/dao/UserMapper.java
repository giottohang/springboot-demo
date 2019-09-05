package com.zmh.stuspringbootdemo.dao;

import com.zmh.stuspringbootdemo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
        int addUser(User user);

        int deleteById(Integer id);

        int updateUser(User user);

        User getById(Integer id);

        User selectByName(String name);
}
