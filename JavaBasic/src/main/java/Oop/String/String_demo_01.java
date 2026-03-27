package Oop.String;

import java.util.Scanner;

public class String_demo_01 {
    //字符串比较
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = "abc";
        String s3 = "Abc";
        Scanner sc = new Scanner(System.in);
        System.out.println("请键盘输入一个字符串：");
        String s4 = sc.next();
        System.out.println(s1);
        System.out.println(s2);
        //比较字符串地址
        System.out.println(s1 == s2);
        //比较字符串内容
        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));//不忽略大小写
        System.out.println(s2.equalsIgnoreCase(s3));//忽略大小写
        System.out.println(s2==s4);//与输入的“abc”作比较
    }
}
//输出：请键盘输入一个字符串：
//abc
//abc
//abc
//false
//true
//false
//true
//false