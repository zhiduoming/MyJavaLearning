package mythread.practice.Practice4;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyRun implements Runnable {

    double total = 100;
    double MIN = 0.01;
    int count = 3;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (count == 0) {
                    System.out.println(Thread.currentThread().getName() + "没有抢到红包!!");
                    break;
                } else {
                    double prize =0;
                    if (count == 1) {
                         prize = total;
                        count--;
                    } else {
                        Random r = new Random();
                        prize = r.nextDouble(MIN, total - MIN * (count - 1));
                        total -= prize;
                        count--;
                    }
                    System.out.println(Thread.currentThread().getName()+"抢到了"+prize+"元");
                    break;

                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
