package mythread.practice.practice3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRun implements Runnable{

    int num=100;
    Lock lock =new ReentrantLock();

    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                if(num<=0){
                    break;
                }else {
                    if(num%2==1){
                        System.out.println(Thread.currentThread().getName()+"打印了"+num);
                        num-=2;
                    }else {
                        num--;
                    }

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
