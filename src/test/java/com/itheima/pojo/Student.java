package com.itheima.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Student {
    private Integer id;

    //@JSONField 注解属性 name ,指定序列化后的名字
    //@JSONField 注解属性 ordinal ,指定序列化后的字段顺序  属性值越小,顺序靠前
    @JSONField(name = "studentName",ordinal = 1)
    private String name;

    @JSONField(ordinal = 2)
    private Integer age;

    //@JSONField 注解属性 serialize ,指定是否序列化该字段
    @JSONField(serialize = false)
    private String email;

    //@JSONField 注解属性 format 指定序列化后的格式
    @JSONField(format = "YYYY-MM-dd")
    private Date birthday;
    private Boolean flag;
}
