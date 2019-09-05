package com.zmh.stuspringbootdemo.dao;

import com.zmh.stuspringbootdemo.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    int addRole(Role role);

    int deleteRole(Integer id);

    int updateRole(Role role);

    Role getRole(Integer id);

    List<Role> getRoleByUserName(String username);

}
