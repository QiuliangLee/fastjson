package com.itheima.dao;

import com.itheima.pojo.User;
import com.itheima.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {

    //jdbcTemplate数据库的操作
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DruidUtils.getDataSource());


    /**
     * 删除数据的方法
     * 接收主键参数
     * 删除数据表中的数据
     */
    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id = ?";
        return jdbcTemplate.update(sql,id);
    }

    /**
     * 修改数据
     * 接收参数User对象
     * 修改数据表
     * 返回结果
     */
    @Override
    public int updateUser(User user) {
        String sql = "update user set name = ? , money = ? where id = ?";
        return jdbcTemplate.update(sql,user.getName(),user.getMoney(),user.getId());
    }

    /**
     * 主键回显查询
     * 接收参数,主键
     * 返回User对象
     */
    @Override
    public User queryUserById(int id) {
        String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    /**
     * 查询所有账户信息的方法
     * 返回值List集合
     */
    @Override
    public List<User> queryAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }

    /**
     * 添加账户数据方法
     * 接收User对象,数据写入到数据库
     */
    @Override
    public int addUser(User user) {
        String sql = "insert into user values(?,?,?)";
        return jdbcTemplate.update(sql,null,user.getName(),user.getMoney());
    }
}
