package com.zmh.stuspringbootdemo.service.Impl;

import com.zmh.stuspringbootdemo.dao.PermissionMapper;
import com.zmh.stuspringbootdemo.dao.RoleMapper;
import com.zmh.stuspringbootdemo.dao.UserMapper;
import com.zmh.stuspringbootdemo.domain.Role;
import com.zmh.stuspringbootdemo.domain.User;
import com.zmh.stuspringbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Primary
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int addUser(User user) {

        return userMapper.addUser(user);
    }

    @Override
    public int deleteById(Integer id) {

        return userMapper.deleteById(id);
    }

    @Override
    public int updateUser(User user) {

        return userMapper.updateUser(user);
    }

    @Override
    public User getById(Integer id) {

        return userMapper.getById(id);
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public Map<String, Object> getAllQXByUserName(String username) {
        List<Role> roles = roleMapper.getRoleByUserName(username);
        Map<String, Object> role_map = new HashMap<>();
        for (Role r : roles) {
            role_map.put(r.getRole_name(),permissionMapper.getPermissionByRoleId(r.getId()));
        }
        return role_map;
    }


}
