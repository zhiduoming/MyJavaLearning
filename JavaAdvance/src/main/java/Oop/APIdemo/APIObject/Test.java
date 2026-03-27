package Oop.APIdemo.APIObject;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        int [] data={1,2,3,4,5,6,7,8,9,0};
        User user1= new User("zhangsan",19,"123456","girl11",data);

        //1.重写Object中的clone方法，2.然后让Javabean类实现cloneable接口  3.创建原对象（强制类型转换）
        User user2 =(User)user1.clone();
        //object中的克隆是浅克隆
        int[] arr =user1.getData();
        arr[0]=199;
        System.out.println(user1);
        System.out.println(user2);


    }
}
