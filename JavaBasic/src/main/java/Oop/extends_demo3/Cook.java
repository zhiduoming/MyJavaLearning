package Oop.extends_demo3;

public class Cook extends Employee{

    public Cook() {
    }

    public Cook(String id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        System.out.println("厨师在炒菜");
    }
}
