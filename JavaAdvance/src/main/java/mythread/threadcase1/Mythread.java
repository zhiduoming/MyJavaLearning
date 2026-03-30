package mythread.threadcase1;

public class Mythread extends Thread {
    //重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("当前线程名字:"+Thread.currentThread().getName()+"hello world");
        }
    }
}
