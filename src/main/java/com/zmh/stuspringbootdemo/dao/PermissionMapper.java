package com.zmh.stuspringbootdemo.dao;

import com.zmh.stuspringbootdemo.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper {

    int addPermission(Permission permission);

    int deletePermission(Integer id);

    int updatePermission(Permission permission);

    Permission getPermission(Integer id);

    List<Permission> getPermissionByRoleId(int role_id);
}
