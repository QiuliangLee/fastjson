package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("deleteUser")
    public @ResponseBody String deleteUser(int id){
        String result = userService.deleteUser(id);
        return result;
    }

    @RequestMapping("updateUser")
    public @ResponseBody String updateUser(@RequestBody User user){
        String result = userService.updateUser(user);
        return result;
    }

    @RequestMapping("queryUserById")
    public @ResponseBody User queryUserById(int id){
        User user = userService.queryUserById(id);
        return user;
    }

    @RequestMapping("addUser")
    public @ResponseBody String addUser(@RequestBody User user){
        String result = userService.addUser(user);
        return result;
    }

    @RequestMapping("queryAll")
    public @ResponseBody List<User> queryAll(){
        List<User> userList = userService.queryAll();
        return userList;
    }
}
