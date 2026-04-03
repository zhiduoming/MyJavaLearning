package IO.serialize;

import java.io.*;

public class ObjectInputStreamdemo {
    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"));
            //从指定文件输入流中读取对象并反序列化
            Object obj = ois.readObject();
            //将反序列化后的对象强制转换为指定类型
            Person p = (Person) obj;
            //打印反序列化后的信息
            System.out.println("Deserialized Object:" + p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
