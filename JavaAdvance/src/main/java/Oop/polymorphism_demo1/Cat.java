package Oop.polymorphism_demo1;

public class Cat extends Animal {


    public Cat() {
    }

    public Cat(String color, int age) {
        super(color, age);
    }

    public void catchMouse(){
        System.out.println("猫在抓老鼠");
    }

    @Override
    public void eat(String something) {
        System.out.println(getAge()+"岁的"+getColor()+"颜色的猫咪侧着头吃"+something);
    }
}
