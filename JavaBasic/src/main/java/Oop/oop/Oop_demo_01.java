package Oop.oop;

public class Oop_demo_01 {
    public static void main(String[] args) {
        //调用方法
        double S1=getArea(23,45);
        double S2=getArea(46,10);
        System.out.println(S1>S2?S1:S2);

        //传参不同即可调用不同的重载方法
        int result =getSum(13 ,45);
        double result2 =getSum(1.4,4.3);
        int  result3= getSum(4,6,8);
        System.out.println(result+" "+result2+" "+result3 );
    }
    //方法写在main方法的外面，类的里面
    //方法名要见名知义，如果只有一个单词全小写，如果有多个单词，从第二个单词开始首字母大写

    //有返回值的调用
    public static double getArea(double len ,double width){
        return len*width;
    }

    //方法的重载：在同一个类里，定义多个同名的方法，每个方法拥有不同的参数类型和参数个数(不看返回值）
    //这两个方法不构成重载，因为不看返回值，只看参数
    /*public static void getSum(int num1,int num2){
        System.out.println(num1+num2);

        //return 可以省略不写
    }*/
    public static  int getSum(int a,int b){
        return a+b;
    }
    public static  int getSum( int a,int b,int c){
        return a+b+c;
    }
    public static double getSum(double a,double b){
        return a+b;
    }
}
