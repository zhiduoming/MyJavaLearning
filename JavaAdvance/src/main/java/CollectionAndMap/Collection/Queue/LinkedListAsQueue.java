package CollectionAndMap.Collection.Queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListAsQueue {
    public static void main(String[] args) {
        LinkedList<String> queue =new LinkedList<>();

        //添加元素
        queue.offer("zhangsan");
        queue.offer("lisi");
        queue.offer("zhaoliu");
        queue.offer("chenyibo");

        //删除元素(只能从队头删）
        queue.poll();
        queue.poll();
        System.out.println(queue);//output : [zhaosi chenyibo]

        //修改元素(不能直接修改，只能先删除后添加)
        queue.poll();
        queue.offer("qifei");
        System.out.println(queue);//output:[chenyibo, qifei]

        //查找元素：使用迭代器
        Iterator<String> it = queue.iterator();
        while(it.hasNext()){
            String s=it.next();
            if(s.equals("qifei")){
                System.out.println("找到了->"+s);
            }
        }
    }
}
