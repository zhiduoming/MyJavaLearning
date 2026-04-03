package reflection.Demo;

import java.io.IOException;

public class Student {
    private String name;
    private int age ;
    public String gender;

    public Student() {
    }

    public Student(String name, int age, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
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

    private String eat(String something)throws IOException,NullPointerException {
        System.out.println("在吃"+something);
        return "奥利给";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
