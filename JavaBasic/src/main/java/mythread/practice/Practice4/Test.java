package mythread.practice.Practice4;

public class Test {
    public static void main(String[] args) {
        //创建MyRun对象
        MyRun mr =new MyRun();

        //创建5个线程
        Thread thread1 =new Thread(mr);
        Thread thread2 =new Thread(mr);
        Thread thread3 =new Thread(mr);
        Thread thread4 =new Thread(mr);
        Thread thread5 =new Thread(mr);

        //起名字
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");
        thread4.setName("线程4");
        thread5.setName("线程5");

        //开启线程
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
