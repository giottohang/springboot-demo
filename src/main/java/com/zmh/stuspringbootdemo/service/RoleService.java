package com.zmh.stuspringbootdemo.service;

import com.zmh.stuspringbootdemo.domain.Role;

import java.util.List;

public interface RoleService {
    int addRole(Role role);

    int deleteRole(Integer id);

    int updateRole(Role role);

    Role getRole(Integer id);

    List<Role> getRoleByUserName(String username);
}
