package com.zmh.stuspringbootdemo.service.Impl;

import com.zmh.stuspringbootdemo.dao.PermissionMapper;
import com.zmh.stuspringbootdemo.domain.Permission;
import com.zmh.stuspringbootdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int addPermission(Permission permission) {
        return permissionMapper.addPermission(permission);
    }

    @Override
    public int deletePermission(Integer id) {
        return permissionMapper.deletePermission(id);
    }

    @Override
    public int updatePermission(Permission permission) {
        return permissionMapper.updatePermission(permission);
    }

    @Override
    public Permission getPermission(Integer id) {
        return permissionMapper.getPermission(id);
    }

    @Override
    public List<Permission> getPermissionByRoleId(int role_id) {
        return permissionMapper.getPermissionByRoleId(role_id);
    }


}
