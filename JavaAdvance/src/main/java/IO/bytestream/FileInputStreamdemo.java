package IO.bytestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamdemo {
    public static void main(String[] args) throws IOException {
        /*//创建一个FileInputStream对象
        FileInputStream fis =new FileInputStream("data3.txt");*/
        InputStreamReader isr =new InputStreamReader(new FileInputStream("data3.txt"));
        //开始读取
        int data;
        while((data=isr.read())!=-1){
            System.out.print((char) data);
        }
        isr.close();
    }
}
