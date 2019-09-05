package com.zmh.stuspringbootdemo.service;

import com.zmh.stuspringbootdemo.domain.Permission;

import java.util.List;


public interface PermissionService {
    int addPermission(Permission permission);

    int deletePermission(Integer id);

    int updatePermission(Permission permission);

    Permission getPermission(Integer id);

    List<Permission> getPermissionByRoleId(int role_id);
}
