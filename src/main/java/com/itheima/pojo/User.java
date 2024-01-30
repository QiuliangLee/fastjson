package com.itheima.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private double money;
}
