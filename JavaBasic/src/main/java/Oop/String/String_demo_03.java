package Oop.String;

import java.util.Scanner;

public class String_demo_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = sc.next();
        printCount(str);
        System.out.println(reverse(str));
        System.out.println("请输入一个数字：");
        int num=sc.nextInt();
        printCapitalNum(num);
    }
    //定义一个方法，统计字符串中大小写字符、数字字符出现的次数
    public static void printCount(String str){
        int Uppercase = 0;
        int Lowercase = 0;
        int digit = 0;
        int others=0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') Lowercase++;
            else if (c >= 'A' && c <= 'Z') Uppercase++;
            else if (c >= '0' && c <= '9') digit++;
            else others++;
        }
        System.out.println("大写字母次数：" + Uppercase);
        System.out.println("小写字母次数：" + Lowercase);
        System.out.println("数字次数：" + digit);
        System.out.println("其他字符次数：" + others);
    }
    //定义一个方法，实现字符串反转
    public static String reverse(String str){
        String newstr="";
        for (int i = str.length()-1; i >= 0; i--) {
            char c=str.charAt(i);
            newstr = newstr + c;
        }
        return newstr;
    }
    public static String getCapitalNum(int a){  String[] str={"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    return str[a];}
    public static void printCapitalNum(int num){
        String newstr="";
        while(num>0){
            int ge=num%10;
            newstr=getCapitalNum(ge)+newstr;
            num/=10;
        }
        String[] array={"佰","拾","万","仟","佰","拾","元"};
        String result="";
        for (int i = 0; i <newstr.length() ; i++) {
            result=result+newstr.charAt(i)+array[i+7-newstr.length()];
        }
        System.out.println(result);
    }
}

