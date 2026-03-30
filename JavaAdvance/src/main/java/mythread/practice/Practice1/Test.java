package mythread.practice.Practice1;

public class Test {
    public static void main(String[] args) {
        //创建MyRun对象
        MyRun mr =new MyRun();

        //创建两个线程对象
        Thread t1 =new Thread(mr);
        Thread t2 =new Thread(mr);

        //给两个线程设置名字
        t1.setName("窗口一");
        t2.setName("窗口二");

        //开启线程
        t1.start();
        t2.start();
    }
}
