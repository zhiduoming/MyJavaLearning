package Oop.static_demo_01;

import java.util.ArrayList;

//工具类
public class StudentUtil {

    private StudentUtil(){}

    public static int getMaxAge(ArrayList<Student> list){
        int maxAge = list.getFirst().getAge();
        for (int i = 0; i < list.size(); i++) {
            int tempAge = list.get(i).getAge();
            if(maxAge<tempAge){
                maxAge =tempAge;
            }
        }
        return maxAge;
    }
}
