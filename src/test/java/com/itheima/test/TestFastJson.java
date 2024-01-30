package com.itheima.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.itheima.pojo.Student;
import org.junit.Test;

import java.util.*;

public class TestFastJson {

    public Date getDate(){
        Date date = new Date();
        return date;
    }

    @Test
    //Json格式字符串,反序列化回到Map集合
    public void testJsonToMap(){
        String jsonString = "{\"student2\":{\"age\":22,\"birthday\":1584260793271,\"email\":\"ls@126.com\",\"id\":2,\"name\":\"李四\"},\"student1\":{\"age\":20,\"birthday\":1584260793271,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"}}";
        //JSON类的静态方法,parseObject
        //直接进行反序列化,Map集合没有泛型的, 泛型没有是不安全的集合
        //转后的集合,必须有泛型
        //调用parseObject,传递参数,TypeReference类型,在TypeReference类的泛型中,传递转后的Map集合
        Map<String,Student> map = JSON.parseObject(jsonString,new TypeReference<Map<String,Student>>(){});
        for (String key : map.keySet()){
            System.out.println(key +"::"+map.get(key));
        }
    }


    @Test
    //Json格式字符串,反序列化回到List集合
    public void testJsonToList(){
        String jsonString = "[{\"age\":20,\"birthday\":1584258063781,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"},{\"age\":22,\"birthday\":1584258063781,\"email\":\"ls@126.com\",\"id\":2,\"name\":\"李四\"}]";
        //JSON类的静态方法, parseArray
        //传递json格式字符串,传递转换后的集合的泛型的class对象
        List<Student> list = JSON.parseArray(jsonString, Student.class);
        for(Student student : list){
            System.out.println(student);
        }
    }

    @Test
    //Json格式字符串,反序列化回到Java对象
    public void testJsonToObject(){
        String jsonString = "{\"age\":20,\"birthday\":1584257759911,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"}";
        //JSON类的静态方法 parseObject
        //传递要反序列化的Json字符串,传递Java对象的class对象
        Student student = JSON.parseObject(jsonString,Student.class);
        System.out.println(student);
    }


    @Test
    //Java中的集合Map,序列化为Json格式字符串
    public void testMapToJson(){
        //创建Map集合,键为字符串类型,值是Student对象
        Map<String,Student> map = new HashMap<String, Student>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("张三");
        student1.setAge(20);
        student1.setEmail("zs@sina.com");
        student1.setBirthday(getDate());

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("李四");
        student2.setAge(22);
        student2.setEmail("ls@126.com");
        student2.setBirthday(getDate());
        //Map集合存储Student对象
        map.put("student1",student1);
        map.put("student2",student2);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        //json格式字符串是对象,对象中有2个键,键对应的值是Student对象
        //{"student2":{"age":22,"birthday":1584260793271,"email":"ls@126.com","id":2,"name":"李四"},"student1":{"age":20,"birthday":1584260793271,"email":"zs@sina.com","id":1,"name":"张三"}}
    }

    @Test
    //Java中的集合List,序列化为Json格式字符串
    public void testListToJson(){
        //集合List,存储Student对象
        List<Student> list = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("张三");
        student1.setAge(20);
        student1.setEmail("zs@sina.com");
        student1.setBirthday(getDate());

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("李四");
        student2.setAge(22);
        student2.setEmail("ls@126.com");
        student2.setBirthday(getDate());
        //Student对象存储到List集合中
        list.add(student1);
        list.add(student2);
        //List集合,序列化为Json格式字符串
        String jsonString = JSON.toJSONString(list);
        System.out.println(jsonString);
        //转后的结果,是数组,数组的元素是对象
        //[{"age":20,"birthday":1584258063781,"email":"zs@sina.com","id":1,"name":"张三"},{"age":22,"birthday":1584258063781,"email":"ls@126.com","id":2,"name":"李四"}]
    }
    @Test
    //Java中的对象,Student对象,序列化为Json格式字符串
    public void testObjectToJson(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setEmail("zs@sina.com");
        student.setBirthday(getDate());
        //student对象,转到Json格式字符串
        //调用静态方法,传递要转换的对象
        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);
        //{"age":20,"birthday":1584257759911,"email":"zs@sina.com","id":1,"name":"张三"}
    }
}
