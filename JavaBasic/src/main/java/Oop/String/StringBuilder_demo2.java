package Oop.String;

import java.util.Scanner;

//判断一个字符串是不是对称字符串
public class StringBuilder_demo2 {
    public static void main(String[] args) {
        //键盘录入
        Scanner sc= new Scanner(System.in);
        String str = sc.next();
        //链式编程
        String reverse = new StringBuilder().append(str).reverse().toString();
//        System.out.println(reverse);
        if(reverse.equals(str)){
            System.out.println("该字符串是对称字符串");
        }else {
            System.out.println("该字符串不是对称字符串");
        }
    }
}
