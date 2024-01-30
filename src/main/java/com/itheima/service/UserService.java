package com.itheima.service;

import com.itheima.pojo.User;

import java.util.List;

public interface UserService {

    /**
     * 删除数据的方法
     * 接收主键参数
     * 调用dao层传递主键
     */
    String deleteUser(int id);

    /**
     * 修改数据
     * 接收参数User对象
     * 调用dao层
     * 返回结果
     */
    String updateUser(User user);

    /**
     * 主键回显查询
     * 接收参数,主键
     * 调用dao层
     * 返回User对象
     */
    User queryUserById(int id);

    /**
     * 查询全部账户数据的业务层
     * 调用dao层的方法获取数据(List)
     * 返回控制层
     */
    List<User> queryAll();

    /**
     * 添加账户数据方法
     * 接收User对象,调用dao层
     */
    String addUser(User user);
}
