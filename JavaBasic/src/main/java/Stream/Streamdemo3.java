package Stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 数组与流
 * 零散数据与流
 */
public class Streamdemo3 {
    public static void main(String[] args) {
        //创建数组
        int[] arr1 ={1,2,3,4,5,6,7,8,9};
        String[] arr2 ={"a","b","c"};
        Student s1 =new Student("zhangsan",21);
        Student s2 =new Student("lisi", 18);
        Student s3 =new Student("wangwu",22);
        Student[] arr3 ={s1,s2,s3};

        //获取数组stream流
        Arrays.stream(arr1).forEach(s-> System.out.print(s+" "));
        System.out.println();
        Arrays.stream(arr2).forEach(s-> System.out.println(s));
        System.out.println();
        Arrays.stream(arr3).forEach(s-> System.out.println(s));

        //获取零散数据的stream流
        Stream.of(1,2,3,4,5,6,7).forEach(System.out::print);
    }
}
