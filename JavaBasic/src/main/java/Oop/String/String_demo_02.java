package Oop.String;

import java.util.Scanner;

//登录系统，有三次机会
public class String_demo_02 {
    public static void main(String[] args) {
        String rightusername = "zhangsan";
        String rightpassword = "123456";
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            if (password.equals(rightpassword) && username.equals(rightusername)) {
                System.out.println("登录成功！");
                break;
            } else {
                if (i == 2) System.out.println("输入的用户名或密码错误，账户已锁定，如有问题请联系Mr.Chen!");
                else {
                    System.out.println("输入的用户名或密码错误，请重新输入,您还有" + (2 - i) + "次机会");
                }
            }
        }

    }
}