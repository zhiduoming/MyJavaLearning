package mythread.threadcase2;

public class ThreadDemo {
    public static void main(String[] args) {
        //创建自己类的对象
        MyRun mr =new MyRun();

        //创建线程对象
        Thread t1 =new Thread(mr);
        Thread t2 =new Thread(mr);

        //给线程设置名字
        t1.setName("线程一");
        t2.setName("线程二");
        //开启线程
        t1.start();
        t2.start();
    }
}
