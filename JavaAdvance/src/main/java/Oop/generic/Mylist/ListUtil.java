package Oop.generic.Mylist;


public class ListUtil {

    private ListUtil(){}
    //私有化这个类的构造方法，防止外界创建该工具类的对象

    /*
    定义一个静态方法addAll,用来添加多个集合的元素
     */

    //泛型方法
    public static<E> void addAll(MyArrayList<E> list , E e1,E e2, E e3){
        list.add(e1);
        list.add(e2);
        list.add(e3);

    }
    //可变参数
    public static <E> void addAll2(MyArrayList<E> list , E...e){
        for (E element : e) {
            list.add(element);
        }
    }

}
