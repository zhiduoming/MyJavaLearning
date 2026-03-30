package mythread.threadmethod;

public class ThreadDemo {
    public static void main(String[] args) {
        //创建线程对象(使用MyThread中继承父类构造,可以在创建线程的时候设置名字)
        Thread t1= new Thread(new MyThread("Thread1"));
        Thread t2= new Thread(new MyThread("Thread2"));
        /*//开启线程
        t1.start();
        t2.start();
*/
        //打印优先级
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        /*//打印main方法的优先级
        System.out.println(Thread.currentThread().getPriority());*/

        //设置优先级
        t1.setPriority(1);
        t2.setPriority(10);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
    }
}
