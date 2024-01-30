package com.itheima.test;
import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Person;
import org.junit.Test;

/**
 * @JSonType 注解
 * 该注解作用于类上,对该类的字段进行序列化和反序列化时的特性功能定制.
 */
public class TestFastJson4 {
    @Test
    public void test(){
        Person person = new Person();
        person.setId(1);
        person.setAddress("北京市");
        person.setName("张三");
        person.setAge(22);
        String jsonString = JSON.toJSONString(person);
        System.out.println(jsonString);
    }
}
