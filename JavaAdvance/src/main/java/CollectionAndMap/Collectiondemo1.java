package CollectionAndMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collectiondemo1 {
    public static void main(String[] args) {
        Collection<String> coll =new ArrayList<>();


        coll.add("zhangsan");
        coll.add("lisi");
        coll.add("chenyibo");
        coll.add("xiaorui");


        /*int size = coll.size();
        //coll.clear();
        System.out.println(coll.contains("lisi"));
        coll.remove("lisi");
        System.out.println(coll.contains("lisi"));
        System.out.println(coll.isEmpty());
        System.out.println(coll);*/
        //用迭代器遍历
        Iterator<String> it = coll.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+", ");
        }
        System.out.println();
        //用增强for进行遍历
        for (String s : coll) {
            System.out.print(s+", ");
        }
        System.out.println();

        //用foreach进行遍历
        coll.forEach(s -> System.out.print(s+", "));

    }
}
