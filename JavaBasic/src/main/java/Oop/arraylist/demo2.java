package Oop.arraylist;

import java.util.ArrayList;
/*
包装类
 byte   Byte
short   Short
char    Character
int     Integer
long    Long
float   Float
double  Double
boolean Boolean
*/


public class demo2 {
    public static void main(String[] args) {
        //存放数字
        ArrayList <Integer> list = new ArrayList<>();
        //添加元素
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        //遍历集合
       /* System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if(i==list.size()-1){
                System.out.print(list.get(i));
            }else {
                System.out.print(list.get(i)+", ");
            }
        }*/
        System.out.println("]");

    }
}
