package com.zmh.stuspringbootdemo.controller;

import com.zmh.stuspringbootdemo.domain.Role;
import com.zmh.stuspringbootdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/addRole/{id}/{role_name}/{user_id}")
    public Object addPermission(@PathVariable Integer id,@PathVariable String role_name,@PathVariable Integer user_id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Role role = new Role();
        role.setId(id);
        role.setRole_name(role_name);
        role.setUser_id(user_id);
        int count = roleService.addRole(role);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/deleteRole/{id}")
    public Object deleteRole(@PathVariable Integer id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        int count = roleService.deleteRole(id);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/updateRole/{id}/{role_name}/{user_id}")
    public Object updateRole(@PathVariable Integer id, @PathVariable String role_name, @PathVariable Integer user_id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        Role role = new Role();
        role.setId(id);
        role.setRole_name(role_name);
        role.setUser_id(user_id);

        int count = roleService.updateRole(role);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/getRole/{id}")
    public Object getRole(@PathVariable Integer id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        result.put("payload", roleService.getRole(id));
        return result;
    }
}
