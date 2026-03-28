package Stream;

import java.util.HashMap;

public class Streamdemo2 {
    public static void main(String[] args) {
        //双列集合

        //创建双列集合
        HashMap<String,Integer > hm =new HashMap<>();
        //添加元素
        hm.put("zhangsan",28);
        hm.put("lisi",29);
        hm.put("wangwu",19);
        hm.put("zhaoliu",21);
        //第一种获取stream流
        hm.keySet().stream().forEach(string -> System.out.println(string));

        System.out.println("---------------------------");
        //第二种方式获取stream流
        hm.entrySet().stream().forEach(s-> System.out.println(s));
    }
}
