package CollectionAndMap.Collection.Queue;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * ArrayDeque作为栈来使用
 */
public class ArrayDequedemo3 {
    public static void main(String[] args) {
        ArrayDeque<String> stack =new ArrayDeque<>();

        //往栈中添加元素
        stack.push("zhangsan");
        stack.push("lisi");
        stack.push("wangwu");
        stack.push("chenyibo");


        //弹出栈顶元素
        String s = stack.pop();
        System.out.println(s);

        //获取栈顶元素
        String s1 = stack.peek();
        System.out.println(s1);

        //修改栈顶元素
        stack.pop();
        stack.push("xiaorui");
        System.out.println(stack);

        //遍历栈查找元素
        int index=-1;
        Iterator<String> it = stack.iterator();
        while(it.hasNext()){
            String string = it.next();
            index++;
            if(string.equals("lisi")){
                break;
            }
        }
        if(index==-1){
            System.out.println("没有找到该元素");
        }else{
            System.out.println("找到了："+"lisi索引是"+index);
        }
    }
}
