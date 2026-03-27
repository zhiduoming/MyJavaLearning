package Oop.extends_demo1;

public class Test {
    public static void main(String[] args) {
        //创建对象并调用方法
        LiHua lh =new LiHua();
        lh.drink();
        lh.catchMouse();
        lh.eat();

        System.out.println("-----------------------------");
        Husky h =new Husky();
        h.breakHome();
        h.drink();
        h.eat();
    }
}
