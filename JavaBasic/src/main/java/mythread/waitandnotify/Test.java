package mythread.waitandnotify;

public class Test {
    public static void main(String[] args) {
        Cook  c =new Cook("厨师");
        Foodie f =new Foodie("吃货");

        //开启线程
        c.start();
        f.start();
    }
}
