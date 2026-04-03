package Oop.polymorphism_demo1;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("老王", 30);
        Person p2 = new Person("老李", 45);
        Animal d =new Dog("黑",2);
        Animal c =new Cat("灰",4);

        p1.keepPet(d,"骨头");
        p2.keepPet(c,"鱼");
    }
}
