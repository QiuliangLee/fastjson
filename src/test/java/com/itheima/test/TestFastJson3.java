package com.itheima.test;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Student;
import org.junit.Test;

import java.util.Date;

/**
 *  @JSonField 注解
 *  该注解作用于方法上,字段上和参数上.可在序列化和反序列化时进行特性功能定制.
 */
public class TestFastJson3 {
    @Test
    public void testObjectToJson(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(getDate());
        student.setEmail("zs@sina.com");
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
    }

    public Date getDate(){
        Date date = new Date();
        return date;
    }
}
