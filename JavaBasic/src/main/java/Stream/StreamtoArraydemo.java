package Stream;

import java.util.ArrayList;
import java.util.Arrays;

public class StreamtoArraydemo {
    public static void main(String[] args) {
        //创建集合并添加元素
        ArrayList<String> list =new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhaoliu");
        list.add("chenyibo");
        list.add("xiaorui");

        //获取流并将其变成数组
        String[] str = list.stream().toArray((length) -> new String[length]);
        System.out.println(Arrays.toString(str));
    }
}
