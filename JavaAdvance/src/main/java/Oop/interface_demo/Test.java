package Oop.interface_demo;

public class Test {

    public static void main(String[] args) {
        Frog f= new Frog("小青",1);
        System.out.println(f.getName()+","+f.getAge());

        f.eat();
        f.Swim();

        Dog d= new Dog("小黑",2);
        System.out.println(d.getName()+","+d.getAge());

        d.eat();
        d.Swim();
    }
}
