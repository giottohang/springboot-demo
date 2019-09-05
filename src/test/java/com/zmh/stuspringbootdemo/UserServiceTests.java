package com.zmh.stuspringbootdemo;

import com.zmh.stuspringbootdemo.domain.Permission;
import com.zmh.stuspringbootdemo.domain.Role;
import com.zmh.stuspringbootdemo.domain.User;
import com.zmh.stuspringbootdemo.service.RoleService;
import com.zmh.stuspringbootdemo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Test
    public void selectByPrimaryKey() {

        User user = userService.getById(1);
        System.out.println(user.getName());
    }

    @Test
    public void getRoleByUserName(){
        List<Role> roles=roleService.getRoleByUserName("giotto");
        System.out.println(roles.get(0).getRole_name());
    }

    @Test
    public void getAllQXByUserName() {
        Map<String, Object> all = userService.getAllQXByUserName("shiroTest");
        for (String key : all.keySet()) {
            String row = "role_name：" + key;
            List<Permission> obj = (List) all.get(key);
            row += ",permisson:";
            for (Permission p : obj) {
                row += p.getPermission() + ",";
            }
            System.out.println(row);
        }
    }

}
