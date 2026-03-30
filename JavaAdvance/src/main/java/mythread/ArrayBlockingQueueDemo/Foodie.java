package mythread.ArrayBlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie extends Thread{
    ArrayBlockingQueue<String> queue;



    public Foodie(String name, ArrayBlockingQueue<String> queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                String food = queue.take();
                System.out.println(food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
