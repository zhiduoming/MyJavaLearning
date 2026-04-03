package mythread.practice.Practice2;

public class Test {
    public static void main(String[] args) {
        //创建MyRun对象
        MyRun mr =new MyRun();

        //创建两个线程
        Thread t1 =new Thread(mr);
        Thread t2 =new Thread(mr);

        //设置名字
        t1.setName("摸仙小月");
        t2.setName("摸仙小蓝");

        //开启线程
        t1.start();
        t2.start();
    }
}
