package IO.characterstream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderdemo {
    public static void main(String[] args) throws IOException {
        //创建一个FileReader对象
        FileReader fr =new FileReader("data3.txt");

        /*//对其进行读取操作
        //1.读取单个字符
        int b;
        while((b=fr.read())!=-1){
            System.out.print((char)b);
        }
        System.out.println("--------------------------");*/

        //2.读取多个字符
        char[] buf = new char[1024];
        int data;
        while(( data=fr.read(buf,0,buf.length))!=-1){
            System.out.println(new String(buf,0,data));
        }
        fr.close();
    }
}
