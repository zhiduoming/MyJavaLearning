package Oop.abstract_demo2;

public class Test {
    public static void main(String[] args) {
        Animal d =new Dog("小黑",2);
        d.eat();
        d.drink();
        System.out.println(d.getName()+","+d.getAge());


        Animal f =new Frog();
        f.setAge(3);
        f.setName("小青");

        f.eat();
        f.drink();
        System.out.println(f.getName()+","+f.getAge());
    }


}
