package Oop.oop;

import java.util.Scanner;

/*数字加密：
* 加密规则：
*           先得到每位数，
*           然后每位数都加上5，
*           再对10取余，
*           最后将所有数字反转，
*           得到一串新数*/
public class Oop_demo_04 {
    public static void main(String[] args) {
        //1.输入原数字
        Scanner sc =new Scanner(System.in);
        int num=sc.nextInt();
        int newnum=encryption(num);
        System.out.println(newnum);
    }

    public static int  encryption(int num){
        //2.获取数字的长度
        int length=0;
        int temp=num;
        while(temp>0){
            temp/=10;
            length++;
        }
        //3.将每位数字存进数组
        int[] nums=new int[length];
        for(int i=0;i<length;i++){
            int digit =num%10;
            nums[i]=(digit+5)%10;
            num/=10;
        }
        //4.得到新数字
        int newnum =0;
        for(int i=0;i<length;i++)
        {
            newnum=newnum*10+nums[i];
        }
        return newnum;
    }
}

