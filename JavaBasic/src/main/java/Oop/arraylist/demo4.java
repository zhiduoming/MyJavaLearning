package Oop.arraylist;

import java.util.ArrayList;
//定义一个方法，根据id查找对应的用户信息
public class demo4 {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        //创建用户对象
        User u1 =new User(1,"zhangsan","123");
        User u2 =new User(2,"lisi","456");
        User u3 =new User(3,"wangwu","789");
        //添加用户对象
        list.add(u1);
        list.add(u2);
        list.add(u3);
        //查找
        int index=getIndex(list,1);
        System.out.println(list.get(index).getId()+","+list.get(index).getUsername()+","+list.get(index).getPassword());

    }
    public static int  getIndex(ArrayList<User> list,int id){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId()==id  )
                return i;
        }
        return -1;
    }
}
