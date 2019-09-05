package com.zmh.stuspringbootdemo.controller;

import com.zmh.stuspringbootdemo.domain.Permission;
import com.zmh.stuspringbootdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/addPermission/{id}/{permission}/{role_id}")
    public Object addPermission(@PathVariable Integer id,@PathVariable String permission,@PathVariable Integer role_id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Permission permissionClass = new Permission();
        permissionClass.setId(id);
        permissionClass.setPermission(permission);
        permissionClass.setRole_id(role_id);
        int count = permissionService.addPermission(permissionClass);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/deletePermission/{id}")
    public Object deletePermission(@PathVariable Integer id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        int count = permissionService.deletePermission(id);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/updatePermission/{id}/{permission}/{role_id}")
    public Object updatePermission(@PathVariable Integer id,@PathVariable String permission,@PathVariable Integer role_id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Permission permissionClass = new Permission();
        permissionClass.setId(id);
        permissionClass.setPermission(permission);
        permissionClass.setRole_id(role_id);

        int count = permissionService.updatePermission(permissionClass);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/getPermission/{id}")
    public Object getPermission(@PathVariable Integer id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        result.put("payload", permissionService.getPermission(id));
        return result;
    }


}
