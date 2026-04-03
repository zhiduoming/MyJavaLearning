package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectDemo {
    public static void main(String[] args) {
        //创建集合
        ArrayList<String> list = new ArrayList<>();
        //添加元素
        Collections.addAll(list, "zhangsan-男-18", "lisi-女-19", "wangwu-男-21", "zhaoliu-女-22");
        /*//获取所有男性并收集到List中
        List<String> list2 = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());

        //获取所有男性并收集到set中(收集到set中可以实现去重)
        List<String> set = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());*/
        //收集到Map集合中
        //吧所有男性收集起来,其中: 键:姓名  值:年龄
        Map<String, Object> map = list.stream().filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        s -> s.split("-")[0]
                        ,
                        s-> Integer.parseInt(s.split("-")[2])));

        System.out.println(map);
    }
}
