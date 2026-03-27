package Oop.arraylist;

import java.util.ArrayList;

public class demo3 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        //创建学生对象
        Student s1 =new Student(19,"zhangsan");
        Student s2 =new Student(19,"lisi");
        Student s3 =new Student(23,"wangwu");
        Student s4 =new Student(24,"zhaosi");

        //添加学生元素
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            Student student =list.get(i);
            System.out.println(student.getAge()+","+student.getName());
        }
    }
}
