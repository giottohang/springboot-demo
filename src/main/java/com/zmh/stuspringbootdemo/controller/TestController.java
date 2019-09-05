package com.zmh.stuspringbootdemo.controller;

import com.zmh.stuspringbootdemo.config.jedis.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/test")
    public Object test(){
        return "hello world!" ;
    }

    //rest接口
    @RequestMapping("/restTest/{name}")
    public Object restTest(@PathVariable String name){
        return "restTest "+name ;
    }

    @Autowired
    private JedisUtil jedis;
    @RequestMapping("/restJedis/{val}")
    public Object restJedis(@PathVariable String val){
        jedis.set("testkey",val);
        return "testJedis_OK";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @RequestMapping("/getJDBC/{id}")
    public Object getJDBC(@PathVariable int id){
        String sql="select * from user where id=" + id;
        Map<String,Object> data=jdbcTemplate.queryForMap(sql);
        return data;
    }

}
