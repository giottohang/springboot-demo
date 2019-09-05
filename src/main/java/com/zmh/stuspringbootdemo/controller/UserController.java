package com.zmh.stuspringbootdemo.controller;

import com.zmh.stuspringbootdemo.domain.User;
import com.zmh.stuspringbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser/{id}/{name}/{password}/{sal}")
    public Object addUser(@PathVariable Integer id,@PathVariable String name,@PathVariable String password,@PathVariable Double sal) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        int count = userService.addUser(user);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/getUser/{id}")
    public Object getUser(@PathVariable Integer id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        result.put("payload", userService.getById(id));
        return result;
    }

    @GetMapping("/deleteById/{id}")
    public Object deleteById(@PathVariable Integer id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        int count = userService.deleteById(id);
        if (count > 0)
            result.put("code", 0);
        return result;
    }

    @GetMapping("/updUser/{name}/{password}/{sal}/{id}")
    public Object updUser(@PathVariable String name, @PathVariable String password
            , @PathVariable Double sal, @PathVariable Integer id) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("code", -1);
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setId(id);
        user.setSal(sal);
        int count = userService.updateUser(user);
        if (count > 0)
            result.put("code", 0);
        return result;
    }


}
