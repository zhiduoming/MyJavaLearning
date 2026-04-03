package Oop.generic.Mylist;

import java.util.Arrays;
/*
创建一个带有泛型的类
 */

public  class MyArrayList<E> {

    Object[] obj =new Object[10];
    int size;

    public boolean add(E e){
        obj[size]=e;
        size++;
        return true;
    }

    public E get(int index){
        return (E)obj[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(obj);
    }
}
