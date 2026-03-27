package Oop.arraylist.Project_StudentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String [] args) {
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            System.out.println("-----------欢迎来到陈氏学生管理系统----------");
            System.out.print("1:添加学生   2:删除学生   3:修改学生   4:查询学生   5：退出系统");
            System.out.println();
            System.out.println("请输入您的选择： ");
            Scanner sc = new Scanner(System.in);

            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("退出");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项");
            }
        }
    }

    //添加学生
    public static void addStudent(ArrayList<Student> list) {
        Student stu = new Student();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入学生的id：");
            String id = sc.next();
            if (contains(list, id)) {
                System.out.println("该学生已经存在，请重新录入");
            } else {
                stu.setId(id);
                break;
            }
        }


        System.out.println("请输入学生的姓名：");
        stu.setName(sc.next());

        System.out.println("请输入学生的年龄： ");
        stu.setAge(sc.nextInt());

        System.out.println("请输入学生的家庭地址： ");
        stu.setAddress(sc.next());
        list.add(stu);
        System.out.println("学生信息添加成功！");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        //做判断，若目前集合里无学生则提示无法删除
        if (list.isEmpty()) {
            System.out.println("当前系统内无学生对象，无法进行删除，请先添加学生");
            return;
        }
        Scanner sc = new Scanner(System.in);
        //若删除的对象不存在，则需重新录入
        while (true) {
            System.out.println("请输入要删除的学生的id");
            String sid = sc.next();
            if (!contains(list, sid)) {
                System.out.println("要删除的学生对象不存在，请重新录入id");
            } else {
                //删除操作
                list.remove(getIndex(list, sid));
                System.out.println("删除成功");
                break;
            }
        }
    }

    //修改学生
    public static void updateStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再修改！");
            return;
        }
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入你要修改的学生的id");
            String sid =sc.next();
            if(!contains(list,sid)){
                System.out.println("该学生对象不存在，请重新录入id");
            }else{
                Student stu =list.get(getIndex(list,sid));
                System.out.println("请输入修改后的学号：");
                stu.setId(sc.next());
                System.out.println("请输入修改后的姓名：");
                stu.setName(sc.next());
                System.out.println("请输入修改后的年龄：");
                stu.setAge(sc.nextInt());
                System.out.println("请输入修改后的家庭地址：");
                stu.setAddress(sc.next());
                System.out.println("学生信息修改完成！");
                break;
            }
        }
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再查询！");
            return;
        }
        //打印表头信息
        System.out.println("id\t\t姓名\t\t年龄\t\t家庭住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getAddress());
        }
    }

    //判断学生id唯一性
    public static boolean contains(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    //返回学生对象的索引
    public static int getIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (id.equals(list.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }
}
