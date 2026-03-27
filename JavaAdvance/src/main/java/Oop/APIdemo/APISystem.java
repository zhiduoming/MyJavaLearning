package Oop.APIdemo;

public class APISystem {
    public static void main(String[] args) {

        //虚拟机正常停止
        //System.exit(0);
        //可以用来统计程序运行的总时间
        //System.out.println(System.currentTimeMillis());
        int [] arr1={1,2,3,4,5,6,7,8,9};
        int [] arr2=new int[10];
        //拷贝数组
        System.arraycopy(arr1,0,arr2,0,9);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
