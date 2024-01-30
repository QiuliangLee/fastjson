package com.itheima.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *  实现Druid 德鲁伊连接池的工具类
 *  从连接池中获取连接
 *  实现步骤:
 *   1: src下创建德鲁伊连接池的配置文件
 *     配置文件的名字自定义, 文件是键值对 properties
 *     配置文件自己写IO流读取
 *
 *   2: 创建DataSource接口实现类对象
 *
 *   3: DataSource接口实现类,获取Connection连接对象
 */
public class DruidUtils {
    //成员位置,创建接口变量
    private static DataSource dataSource  ;
    static {
        try {
            //类加载器,获取字节输入流,读取德鲁伊配置文件
            InputStream inputStream =
                    DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            //创建集合对象
            Properties properties = new Properties();
            //集合 IO管理
            properties.load(inputStream);

            //创建DataSource接口实现类对象
            //德鲁伊连接池,简单工厂模式,创建的DataSource接口实现类对象
            //德鲁伊连接池中定义类:  DruidDataSourceFactory ,静态方法 createDataSource() 获取的接口实现类
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * 静态方法: 返回连接池对象
     * 返回DataSource接口实现类对象
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 静态方法: 返回数据库连接对象
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }




    public static void close(ResultSet rs, Statement stat, Connection con){
        //判断结果集对象,不是空,关闭
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //判断SQL语句执行对象,不是空,关闭
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //判断连接对象,不是空,关闭
        //判断SQL语句执行对象,不是空,关闭
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
