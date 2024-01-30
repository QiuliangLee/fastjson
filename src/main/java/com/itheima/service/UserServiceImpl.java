package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 删除数据的方法
     * 接收主键参数
     * 调用dao层传递主键
     */
    @Override
    public String deleteUser(int id) {
        int i = userDao.deleteUser(id);
        return i > 0 ?"删除成功":"删除失败";
    }

    /**
     * 修改数据
     * 接收参数User对象
     * 调用dao层
     * 返回结果
     */
    @Override
    public String updateUser(User user) {
        int i = userDao.updateUser(user);
        return i > 0 ?"修改成功":"修改失败";
    }

    /**
     * 主键回显查询
     * 接收参数,主键
     * 调用dao层
     * 返回User对象
     */
    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public String addUser(User user) {
        int i = userDao.addUser(user);
        return i>0?"添加成功":"添加失败";
    }
}
