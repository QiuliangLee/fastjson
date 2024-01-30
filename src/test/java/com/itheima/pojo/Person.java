package com.itheima.pojo;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

@Data
// 注解的属性 includes 要被序列化的字段
// 注解的属性 orders 要被序列化的字段的顺序
@JSONType(includes = {"id","name","age","address"},orders = {"name","age","id","address"})
public class Person {
    private int id;
    private String name;

    private int age;
    private String address;
}
