package CollectionAndMap.Collection.Queue;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequedemo4 {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();

        //往队尾添加元素
        queue.offer("zhangsan");
        queue.offer("lisi");
        queue.offer("wangwu");
        queue.offer("chenyibo");

        //弹出队首元素
        String s1 = queue.poll();
        System.out.println(s1);

        //修改队列元素
        queue.poll();
        queue.offer("xiaorui");
        System.out.println(queue);

        //查找元素
        int index=0;
        Iterator<String> it =queue.iterator();
        while(it.hasNext()){
            String s = it.next();
            if(s.equals("wangwu")){
                System.out.println("元素在队列中的位置为："+index );
                break;
            }
            index++;
        }
    }

}
