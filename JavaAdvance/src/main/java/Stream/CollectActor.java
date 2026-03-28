package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectActor {
    public static void main(String[] args) {
        /*
         数据操作
         现在有两个ArrayList集合
         第一个集合中
         存储6名男演员的名字和年龄。
         第二个集合中：“存储6名女演员的名字和年龄。
         姓名和年龄中间用逗号隔开。比如：张三,23
         要求完成如下的操作：
         1，男演员只要名字为3个字的前两人
         2，女演员只要姓杨的，并且不要第一个
         3，把过滤后的男演员姓名和女演员姓名合并到一起
         4，将上一步的演员信息封装成Actor对象。
         5，将所有的演员对象都保存到List集合中。
         备注：演员类Actor，属性只有一个：name，age
         */

        //定义集合存储男演员信息
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张三,23", "李四,24", "谢霆锋,25", "李易峰,26", "张杰,35", "薛之谦,38");
        //定义集合存储女演员信息
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "杨幂,24", "迪丽热巴,22", "杨颖,26", "杨淑珍,25", "鞠婧祎,28", "张婧仪,29");
        //过滤男演员
        Stream<String> stream1 = list1.stream()
                .filter(s -> s.split(",")[0].length() == 3)
                .limit(2);
        //过滤女演员
        Stream<String> stream2 = list2.stream()
                .filter(s -> s.split(",")[0].startsWith("杨"))
                .skip(1);
        //合并流
        Stream<String> stream = Stream.concat(stream1, stream2);
        Map<String, Integer> map = stream.collect(Collectors.toMap(
                s -> s.split(",")[0]
                ,
                s -> Integer.parseInt(s.split(",")[1])
        ));

        //封装成对象
        List<Actor> list =new ArrayList<>();
        map.forEach((name, age) ->list.add(new Actor(name, age)) );

        System.out.println(list);

    }
}
