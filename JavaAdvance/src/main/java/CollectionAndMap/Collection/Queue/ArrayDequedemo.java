package CollectionAndMap.Collection.Queue;

import java.util.ArrayDeque;

public class ArrayDequedemo {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();

        //添加元素
        deque.add("zhangsan");
        deque.add("lisi");
        deque.add("wangwu");
        deque.add("chenyibo");

        //删除元素
        deque.remove("zhangsan");

        //修改元素
        deque.remove("wangwu");
        deque.add("xiaorui");

        //查找元素
        boolean haschenyibo =deque.contains("chenyibo");
        System.out.println("deque包含chenyibo吗？"+haschenyibo);
        System.out.println(deque);
    }
}
