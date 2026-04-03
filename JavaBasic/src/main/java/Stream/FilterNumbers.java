package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNumbers {
    public static void main(String[] args) {
        /*
        定义集合,并添加一些整数1,2,3,4,5,6,7,8,9,10
        过滤奇数,只留下偶数,并将结果保存下来
         */

        //定义集合并添加元素
        ArrayList<Integer> list =new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,8,9,10);
        List<Integer> result = list.stream()
                .filter(s -> s % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
