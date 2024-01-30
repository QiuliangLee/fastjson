package com.itheima.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.itheima.pojo.Student;
import org.junit.Test;

import java.util.Date;

/**
 *  SerializerFeature 枚举 : 进行序列化时,可以自己定义特殊需求
 *  JSON静态方法 toJSONString()
 *  方法的参数: 第一个是要序列化的对象
 *  方法的参数: 第二个参数SerializerFeature枚举类型的可变参数
 *  SerializerFeature枚举的常量,做序列化的个性需求
 */
public class TestFastJson2 {
    //WriteDateUseDateFormat 枚举常量,序列化,日期的格式化
    //PrettyFormat 枚举常量,序列化,格式化
    @Test
    public void testWriteDateUseDate_FormatPrettyFormat(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(getDate());
        student.setEmail("zs@sina.com");
        String jsonString = JSON.toJSONString(student,SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.PrettyFormat);
        System.out.println(jsonString);
    }

    @Test
    //WriteNullBooleanAsFalse 枚举常量,序列化,布尔值为null,序列化false
    public void testWriteNullBooleanAsFalse(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(getDate());
        student.setEmail("zs@sina.com");
//        student.setFlag(true);
        String jsonString = JSON.toJSONString(student,SerializerFeature.WriteNullBooleanAsFalse);
        System.out.println(jsonString);
    }

    @Test
    //WriteNullNumberAsZero 枚举的常量,序列化自动值为null,序列化为0
    public void testWriteNullNumberAsZero(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
//        student.setAge(20);
        student.setBirthday(getDate());
        student.setEmail("zs@sina.com");
        //方法的参数上,添加枚举类型
        String jsonString = JSON.toJSONString(student,SerializerFeature.WriteNullNumberAsZero);
        System.out.println(jsonString);
    }


    @Test
    //WriteNullStringAsEmpty 枚举的常量,序列化为null的字段,值序列化为""
    public void testWriteNullStringAsEmpty(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(getDate());
        //student.setEmail("zs@sina.com");
        //方法的参数上,添加枚举类型
        String jsonString = JSON.toJSONString(student,SerializerFeature.WriteNullStringAsEmpty);
        System.out.println(jsonString);
    }


    @Test
    //WriteMapNullValue 枚举中的常量,序列化null值的字段
    public void testWriteMapNullValue(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(getDate());
        //student.setEmail("zs@sina.com");
        //方法的参数上,添加枚举类型
        String jsonString = JSON.toJSONString(student, SerializerFeature.WriteMapNullValue);
        System.out.println(jsonString);
    }

    public Date getDate(){
        Date date = new Date();
        return date;
    }
}
