package CollectionAndMap.Map;

import java.util.TreeMap;

public class TreeMapdemo2 {
    public static void main(String[] args) {
        TreeMap<Student,String> tm =new TreeMap<>(((o1, o2) -> {
            int agecmp=o2.getAge()-o1.getAge();
            return agecmp!=0? agecmp: o2.getName().compareTo(o1.getName());
        }));

        Student s1=new Student("zhangsan",89);
        Student s2=new Student("lisi",20);
        Student s3=new Student("wangwu",68);
        tm.put(s1,"shanghai");
        tm.put(s2,"guangzhou");
        tm.put(s3,"beijing");
        System.out.println(tm);
    }
}
