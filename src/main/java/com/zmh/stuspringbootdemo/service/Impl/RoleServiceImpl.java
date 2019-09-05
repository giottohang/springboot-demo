package com.zmh.stuspringbootdemo.service.Impl;

import com.zmh.stuspringbootdemo.dao.RoleMapper;
import com.zmh.stuspringbootdemo.domain.Role;
import com.zmh.stuspringbootdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    @Override
    public int deleteRole(Integer id) {
        return roleMapper.deleteRole(id);
    }

    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    @Override
    public Role getRole(Integer id) {
        return roleMapper.getRole(id);
    }

    @Override
    public List<Role> getRoleByUserName(String username) {
        return roleMapper.getRoleByUserName(username);
    }
}
