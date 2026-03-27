package Oop.arraylist;

import java.util.ArrayList;
//定义一个方法，将价格低于1200的手机信息返回
public class demo5 {
    public static void main(String[] args) {
        ArrayList<Phone> list =new ArrayList<>();
        Phone p1 =new Phone("小米",100);
        Phone p2 =new Phone("华为",1000);
        Phone p3 =new Phone("OPPO",1500);
        list.add(p1);
        list.add(p2);
        list.add(p3);

        ArrayList<Phone> resultlist =getInformation(list);
        for (int i = 0; i < resultlist.size(); i++) {
            System.out.println(resultlist.get(i).getBrand()+","+resultlist.get(i).getPrice());
        }
    }
    //如果返回的时候需要返回多个值，则可以将其放在一个容器里，例如：数组、集合
    public static ArrayList<Phone> getInformation(ArrayList<Phone> list){
        ArrayList<Phone> result=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Phone p =list.get(i);
            if(p.getPrice()<1200){
                result.add(p);
            }
        }
        return result;
    }
}
