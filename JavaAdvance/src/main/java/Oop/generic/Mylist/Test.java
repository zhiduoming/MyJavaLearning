package Oop.generic.Mylist;

public class Test {
    public static void main(String[] args) {

        MyArrayList<String> list = new MyArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("chenyibo");
        list.add("xiaorui");

        //System.out.println(list.toString());
        System.out.println(list.get(3));
        System.out.println(list.toString());
        ListUtil.addAll(list, "qifei", "subo", "monkey");
        System.out.println(list.toString());
        ListUtil.addAll2(list, "wuhao", "feige");
        System.out.println(list);


    }
}
