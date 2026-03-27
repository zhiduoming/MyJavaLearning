package Oop.extends_demo2;

public class Sharpei extends Dog{
    @Override
    public void eat() {
        super.eat();
        System.out.println("吃骨头");
    }
}
