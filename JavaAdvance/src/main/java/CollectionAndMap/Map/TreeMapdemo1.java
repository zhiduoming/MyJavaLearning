package CollectionAndMap.Map;

import java.util.TreeMap;

public class TreeMapdemo1 {
    public static void main(String[] args) {
        //键存放商品编号，值存放商品名称
        //根据键值升序排列
        TreeMap<Integer, String> tm =new TreeMap<>();
        tm.put(5,"雪碧");
        tm.put(4,"可口可乐");
        tm.put(3,"六个核桃");
        tm.put(2,"脉动");
        System.out.println(tm);

        //根据键值降序排列
        TreeMap<Integer,String >newtm =new TreeMap<>(((o1, o2) -> o2-o1));
        newtm.put(5,"雪碧");
        newtm.put(4,"可口可乐");
        newtm.put(3,"六个核桃");
        newtm.put(2,"脉动");
        System.out.println(newtm);
    }
}
