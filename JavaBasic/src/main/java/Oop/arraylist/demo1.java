package Oop.arraylist;

import java.util.ArrayList;

public class demo1 {
    public static void main(String[] args) {
        //集合的创建
        // <>中是泛型：限定集合中存储数据的对象   （）中没有参数
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list);

        //删除元素
        //remove直接删除元素，返回值是boolean，如果该元素不存在，则返回false
        boolean result1 = list.remove("aaa");
        System.out.println(result1);
        System.out.println(list);
        //remove删除索引对应的元素，返回值是String，返回被删除的元素,若该索引不存在，会报错
        String result2 = list.remove(0);
        System.out.println(result2);
        System.out.println(list);

        //修改元素
        String result4 = list.set(0, "ggg");
        System.out.println(result4);        //返回旧索引对应的元素
        System.out.println(list);

        //查询元素
        String s =list.get(0);
        System.out.println(s);

        //获取集合的长度
        int length =list.size();
        System.out.println(length);

        //集合的遍历
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(str);
        }
    }
}
