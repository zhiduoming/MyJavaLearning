package mythread.threadcase1;

public class ThreadDemo {
    public static void main(String[] args) {
        //创建线程
        Mythread mythread1 = new Mythread();
        Mythread mythread2 = new Mythread();

        //给线程起名字
        mythread1.setName("线程一");
        mythread2.setName("线程二");

        //调用线程
        mythread1.start();
        mythread2.start();

    }
}
