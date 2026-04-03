package Oop.abstract_demo1;

//抽象类
public abstract class Person {

    private String name;
    private int age;


    //作用：当创建子类对象时给属性进行赋值的
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //抽象方法
    public abstract void work();

    //抽象类不能实例化，即不能创建对象
    //抽象类中不一定有抽象方法，但有抽象方法的类一定是抽象类
    //抽象类可以有构造方法
}
