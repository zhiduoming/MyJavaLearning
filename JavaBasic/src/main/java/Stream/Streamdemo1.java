package Stream;

import java.util.ArrayList;
import java.util.function.Function;

/**
 * 中间操作
 * 过滤: filter(boolean)
 * 转化: map(原类型,新类型)or map(lambda表达式)
 * 跳过: skip(long n) 跳过n个元素
 * 获取: limit(long maxsize) 获取前n个元素
 * 匹配: anyMatch()，只要有一个元素匹配传入的条件，就返回 true。
 *      allMatch()，只有有一个元素不匹配传入的条件，就返回 false；如果全部匹配，则返回 true。
 *      noneMatch()，只要有一个元素匹配传入的条件，就返回 false；如果全部不匹配，则返回 true
 * 去重: distinct()元素去重,依赖hashcode和equals方法
 * 合并: contact(a流,b流)将两个流合并成一个流
 */
public class Streamdemo1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张无忌-20");
        list.add("周芷若-21");
        list.add("赵敏-24");
        list.add("张强-14");
        list.add("张三丰-25");
        //过滤数据
        list.stream().filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(string -> System.out.println(string));

        System.out.println();

        //转化数据
        //写法一:(使用匿名内部类)
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
               return  Integer.parseInt(s.split("-")[1]);
            }
        }).forEach(System.out::println);

        //写法二:(使用lambda表达式)
        list.stream()
                .map(s->Integer.parseInt(s.split("-")[1]))
                .forEach(System.out::println);
    }
}