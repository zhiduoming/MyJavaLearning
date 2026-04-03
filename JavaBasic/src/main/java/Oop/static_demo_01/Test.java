package Oop.static_demo_01;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        Student s1 = new Student("zhangsan", 18, "男");
        Student s2 = new Student("lisi", 19, "女");
        Student s3 = new Student("wangwu", 20, "男");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        //调用工具类，求集合中所有学生的最大年龄
        int age = StudentUtil.getMaxAge(list);
        System.out.println(age);
    }
}
