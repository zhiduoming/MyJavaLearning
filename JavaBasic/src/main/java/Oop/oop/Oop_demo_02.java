 /*
  *         定义方法实现自己产生一个5位的验证码
  *         验证码格式：
  *         长度为5
  *         前四位是大写或小写字母
  *         最后一位是数字
  */
 package Oop.oop;

//生成一个5位数的验证码，其中前四位是大小写字母，而第五位是一个数字
 import java.util.Random;

 public class Oop_demo_02 {
     public static void main(String[] args) {
        String code =generateCode();
         System.out.println("生成的验证码："+ code);
     }


     public static String generateCode() {
         char[] ch = new char[52];
         int index = 0;
         for (int i = 0; i < ch.length; i++) {
             //存小写字母
             if (i <= 25) {
                 ch[index++] = (char) ('a' + i);
             } else {
                 ch[index++] = (char) ('A' + i - 26);
             }
         }
         //定义一个空字符串来存放最终结果
         String result = "";
         Random r = new Random();
         for (int i = 0; i < 4; i++) {
             int randomIndex = r.nextInt(ch.length);
             //字符串拼接，后面可以用StringBuilder
             result += ch[randomIndex];
         }
         int num = r.nextInt(10);
         result += num;
         return result;
     }
 }



