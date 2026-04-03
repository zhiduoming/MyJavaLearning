package Oop.APIdemo;

import java.util.Arrays;

public class APIArrays {
    public static void main(String[] args) {
        int[] arr = {6, 34, 43, 7, 99, 37, 26, 87, 55, 4, 3, 7, 4, 34, 73, 4, 43, 7};

        String string = Arrays.toString(arr);
        System.out.println(string);
        System.out.println("-----------------");


        int result = Arrays.binarySearch(arr, 55);
        System.out.println(result);
        System.out.println("---------------");


        int[] copyOf = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(copyOf));
        System.out.println("--------------------");

        int[] copyOfRange = Arrays.copyOfRange(arr, 4, 10);
        System.out.println(Arrays.toString(copyOfRange));
        System.out.println("----------------------");

        /*Arrays.fill(arr,3);
        System.out.println(Arrays.toString(arr));*/
        Integer[] arr2 = {38, 49, 59, 31, 4, 6, 4, 9, 78, 54, 33};
        String[] arr3 = {"a", "aaaa", "aaa", "aaaaa", "aaaaaaa"};
        Arrays.sort(arr2, (o1, o2) -> o1 - o2);
        Arrays.sort(arr3,((o1, o2) -> o1.length()-o2.length()));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr2));

    }

}
