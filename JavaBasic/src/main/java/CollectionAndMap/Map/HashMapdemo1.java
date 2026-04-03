package CollectionAndMap.Map;

import java.util.HashMap;

public class HashMapdemo1 {
    public static void main(String[] args) {
        HashMap<String,Integer> map =new HashMap<>();
        //添加键值对
        map.put("zhangsan",20);
        map.put("lisi",34);
        map.put("wangwu",19);
        map.put("chenyibo", 25);

        //删除元素（删除键）
        map.remove("zhangsan");

        //修改元素
        map.put("zhangsan",27);

        //查找元素
        Integer age = map.get("lisi");


    }
}
