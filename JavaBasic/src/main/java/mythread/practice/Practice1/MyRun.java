package mythread.practice.Practice1;

public class MyRun implements Runnable{

    static int count =1000;



    @Override
    public void run() {
        //循环
        while(true){
            //同步代码块
            synchronized (MyRun.class){
                //判断是否达到共享数据的末尾
                if(count==0){
                    break;
                }else {
                    //核心逻辑
                    //先睡3000毫秒
                    try {
                        Thread.sleep(30);
                        System.out.println(Thread.currentThread().getName()+"卖出了一张票,还剩"+(count-1)+"张票");
                        count--;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        }
    }
}
