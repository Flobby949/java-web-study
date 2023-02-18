package top.flobby.web.entity;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

/**
 * @author : Flobby
 * @program : java-web-learning
 * @description :
 * @create : 2023-02-18 17:00
 **/

@Data
public class Student {
    private String name;
    private Integer age;
}


class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("flobby");
        student.setAge(21);

        String jsonString = JSON.toJSONString(student);
        System.out.println(jsonString);

        String json = "{\n" +
                "  \"name\": \"jcx\",\n" +
                "  \"age\":21\n" +
                "}";
        Student parseObject = JSON.parseObject(json, Student.class);
        System.out.println(parseObject);
    }
}