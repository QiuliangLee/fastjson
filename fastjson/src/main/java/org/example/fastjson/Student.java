package org.example.fastjson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author liqiuliang
 * @create 2024-01-30 1:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer age;
    private String name;
    private Date date;
}
