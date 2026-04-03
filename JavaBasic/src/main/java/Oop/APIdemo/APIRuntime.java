package Oop.APIdemo;


import java.io.IOException;

public class APIRuntime {
    public static void main(String[] args) throws IOException {
        Runtime r1 = Runtime.getRuntime();
        Runtime r2 = Runtime.getRuntime();

        System.out.println(r1==r2);
        //停止虚拟机
        //Runtime.getRuntime().exit(0);
        //获取CPU的线程数
        int num = Runtime.getRuntime().availableProcessors();
        System.out.println(num );
        System.out.println("-------------------");
        //JVM能从系统中获取总内存的大小
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        System.out.println("-------------------");
        //JVM已经从系统中获得的总内存的大小
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
        System.out.println("-------------------");
        //JVM剩余内存大小
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("-------------------");
        //运行cmd
        Runtime.getRuntime().exec("shutdown -a");
    }


}
