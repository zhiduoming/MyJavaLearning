package mythread.waitandnotify;

public class Foodie extends Thread {
    public Foodie() {
    }

    public Foodie(String name) {
        super(name);
    }

    @Override
    public void run() {
        /*
        1.循环
        2.同步代码块
        3.判断共享数据是否到了末尾(到了末尾)
        4.判断共享书局是否到了末尾(没有到末尾)
         */

        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {

                    //核心逻辑
                    //判断桌子上有没有食物
                    if(Desk.foodflag==0){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        Desk.count--;
                        System.out.println("吃货正在吃面条,还能再吃:"+Desk.count+"碗!!!");
                        Desk.lock.notifyAll();
                        Desk.foodflag=0;
                    }
                    //如果没有就等待
                    //如果有就吃,吃完吩咐厨师继续做
                    //更新食物标志状态,count--
                }
            }
        }
    }
}
