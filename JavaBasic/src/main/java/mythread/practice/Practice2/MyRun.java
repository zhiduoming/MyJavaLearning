package mythread.practice.Practice2;

public class MyRun implements Runnable{

    int count =100;

    @Override
    public void run() {
        //循环
        while(true){
            //同步代码块
            synchronized(this){
                //判断功效条件是否达到末尾
                if(count<10){
                    System.out.println("送出礼物数量已达标,不能再送出");
                    break;
                }else{
                    count--;
                    System.out.println(Thread.currentThread().getName()+"送出了一份礼物,还剩"+count+"份礼物");
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
