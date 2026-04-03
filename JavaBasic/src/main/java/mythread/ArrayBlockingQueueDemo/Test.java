package mythread.ArrayBlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    public static void main(String[] args) {
        //创建阻塞队列对象
        ArrayBlockingQueue<String> queue =new ArrayBlockingQueue<>(1);

        //创建厨师和吃货的对象
        Cook c =new Cook("厨师",queue);
        Foodie f =new Foodie("吃货",queue);

        //开启线程
        c.start();
        f.start();
    }
}
