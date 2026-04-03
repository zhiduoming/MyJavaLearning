package mythread.waitandnotify;

public class Cook extends Thread {
    public Cook(String name) {
        super(name);
    }

    public Cook() {
    }

    @Override
    public void run() {
        /*
         * 1.循环
         * 2.同步代码块
         * 3.判断共享数据是否达到了末尾(到了末尾)
         * 4.判断共享数据是否达到了末尾(没有到末尾)
         */

        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if(Desk.foodflag==1){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }else {
                        System.out.println("厨师做了一碗面条");
                        Desk.foodflag=1;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
