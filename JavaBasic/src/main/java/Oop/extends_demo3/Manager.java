package Oop.extends_demo3;

public class Manager extends Employee {
    private int manageSalary;


    //构造方法

    //空参构造
    public Manager() {
    }
    //代全部参数的构造
    public Manager(String id, String name, int salary, int manageSalary) {
        super(id, name, salary);
        this.manageSalary = manageSalary;
    }

    public int getManageSalary() {
        return manageSalary;
    }

    public void setManageSalary(int manageSalary) {
        this.manageSalary = manageSalary;
    }

    @Override
    public void work() {
        System.out.println("管理其他人");
    }
}
