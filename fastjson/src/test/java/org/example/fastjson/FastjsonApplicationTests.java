package org.example.fastjson;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class FastjsonApplicationTests {

    @Test
    void contextLoads() {
        Student student = new Student(12, "lucas", new Date(0));
        Student student2 = new Student(12, "lucas2", new Date(0));
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student2);
        Map<String, Student> map = new HashMap<>();
        map.put(student.getName(), student2);
        map.put(student2.getName(), student2);
        String jsonString = JSON.toJSONString(student);
        Student student1 = JSON.parseObject(jsonString, Student.class);
        System.out.println(jsonString);
        System.out.println(student1);
        String str = " { \"lucas\":{\"age\":12,\"date\":\"1970-01-01 08:00:00\",\"name\":\"lucas2\"}, \"lucas2\":{\"age\":12,\"date\":\"1970-01-01 08:00:00\",\"name\":\"lucas2\"}}";
        String str2 = " [{\"age\":12,\"date\":\"1970-01-01 08:00:00\",\"name\":\"lucas2\"}, {\"age\":12,\"date\":\"1970-01-01 08:00:00\",\"name\":\"lucas2\"}]";
        Map<String, Student> stringStudentMap = JSON.parseObject(str, new TypeReference<Map<String, Student>>() {
        });
        System.out.println(stringStudentMap);
    }

}
