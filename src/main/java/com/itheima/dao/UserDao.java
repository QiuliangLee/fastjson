package com.itheima.dao;

import com.itheima.pojo.User;

import java.util.List;

public interface UserDao {

    /**
     * 删除数据的方法
     * 接收主键参数
     * 删除数据表中的数据
     */
    int deleteUser(int id);


    /**
     * 修改数据
     * 接收参数User对象
     * 修改数据表
     * 返回结果
     */
    int updateUser(User user);


    /**
     * 主键回显查询
     * 接收参数,主键
     * 返回User对象
     */
    User queryUserById(int id);


    /**
     * 查询所有账户信息的方法
     * 返回值List集合
     */
    List<User> queryAll();


    /**
     * 添加账户数据方法
     * 接收User对象,数据写入到数据库
     */
    int addUser(User user);
}
