package OJ.B;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Student {
    private String id;
    private String name;
    private int mathScore;
    private int englishScore;
    private int javaScore;

    public Student() {
    }

    public Student(String id, String name, int mathScore, int englishScore, int javaScore) {
        this.id = id;
        this.name = name;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.javaScore = javaScore;
    }

    public String getId() {
        return this.id;
    }

    public void updateScore(int mathScore, int englishScore, int javaScore) {
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.javaScore = javaScore;
    }

    public double getAverageScore() {
        return (mathScore + englishScore + javaScore) / 3.0;
    }

    public void printAverageInfo() {
        System.out.println("Student ID:" + id);
        System.out.println("Name:" + name);
        System.out.printf("Average Score:%.1f%n", getAverageScore());
    }

}

class StudentManager {
    private static Map<String , Student> students =new HashMap<>();

    public static void addStudentInfo(String id,String name,int mathScore,int englishScore,int javaScore){
        if(students.containsKey(id)) {
            System.out.println("Students already exist");
            return;
        }
        Student stu = new Student(id, name, mathScore, englishScore, javaScore);
        students.put(id,stu);
        System.out.println("Add success");
    }

    public static void deleteStudentInfo(String id) {
        if(!students.containsKey(id)){
            System.out.println("Students do not exist");
            return;
        }
        students.remove(id);
        System.out.println("Delete success");
    }

    public static void updateStudentInfo(String id,int mathScore,int englishScore,int javaScore){
        if(!students.containsKey(id)){
            System.out.println("Students do not exist");
            return;
        }
        Student stu = students.get(id);
        stu.updateScore(mathScore,englishScore,javaScore);
        System.out.println("Update success");
    }
    public static void printStudentInfo(String id){
        if(!students.containsKey(id)){
            System.out.println("Students do not exist");
            return;
        }
        Student stu = students.get(id);
        stu.printAverageInfo();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int ans = sc.nextInt();
            switch (ans){
                //添加学生信息
                case 1 -> StudentManager.addStudentInfo(sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
                case 2 -> StudentManager.deleteStudentInfo(sc.next());
                case 3 -> StudentManager.updateStudentInfo(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
                case 4 -> StudentManager.printStudentInfo(sc.next());
            }
        }
    }
}

