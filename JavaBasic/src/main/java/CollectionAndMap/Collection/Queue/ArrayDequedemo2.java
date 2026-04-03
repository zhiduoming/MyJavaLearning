package CollectionAndMap.Collection.Queue;

import java.util.ArrayDeque;
import java.util.StringJoiner;

//ArrayDeque作为双端队列来使用
public class ArrayDequedemo2 {
    public static void main(String[] args) {
        ArrayDeque<String> deque =new ArrayDeque<>();
        //往队尾添加元素；
        deque.offerLast("zhangsan");
        deque.offerLast("lisi");
        deque.offerLast("wangwu");
        //往队首添加元素
        deque.addFirst("chenyibo");
        deque.addFirst("xiaorui");

        //删除队首元素
        String s = deque.pollFirst();
        System.out.println(s);

        //删除队尾元素
        String s1 = deque.pollLast();
        System.out.println(s1);

        //获取队首元素但不删除
        String s2= deque.peekFirst();
        System.out.println(s2);

        //获取队尾元素但不删除
        String s3 =deque.peekLast();
        System.out.println(s3);



    }
}
