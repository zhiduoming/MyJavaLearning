package CollectionAndMap.Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Listdemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(4);
        list.add(5);

//        list.remove(1);
        Integer i = Integer.valueOf("1451421");
        list.add(i);
//        Integer data= 30;
//        list.remove(data);

        ListIterator<Integer> lit= list.listIterator();
        while(lit.hasNext()){
            Integer integer = lit.next();
            System.out.print(integer+", ");
            if(integer==20){
                lit.add(512);
            }
        }
        System.out.println();


        System.out.println(list);
    }
}
