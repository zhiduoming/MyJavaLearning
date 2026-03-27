package Oop.String;

public class StringBuilder_demo1 {
    public static void main(String[] args) {
        int[] arr={4,5,7,3,6,98};
        String str=arrToString(arr);
        System.out.println(str);
    }
    //使用StringBuilder来拼接字符串，将一个整型数组拼接成一个新的字符串如int[] arr={1,2,3 };输出结果[1,2,3]
    public static String arrToString(int[] arr){
        StringBuilder sb =new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
                if(i==arr.length-1){
                    sb.append(arr[i]);
                }else {
                    sb.append(arr[i]).append(",");
                }
        }
        sb.append("]");
        return sb.toString();
    }
}
