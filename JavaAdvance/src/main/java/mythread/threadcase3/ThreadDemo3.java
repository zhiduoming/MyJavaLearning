package mythread.threadcase3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建MyCallable对象
        MyCallable mc =new MyCallable();

        //创建FutureTask的对象(用于管理多线程运行的结果)
        FutureTask<Integer> ft =new FutureTask<>(mc);

        //创建线程的对象
        Thread t1 =new Thread(ft);
        //Thread t2 =new Thread(ft);

        //启动线程
        t1.start();

        //获取多线程运行的结果
        Integer result = ft.get();
        System.out.println(result);


    }
}
