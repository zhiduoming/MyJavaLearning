package IO.bytestream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamdemo {
    public static void main(String[] args) throws IOException {
        //以文件名为参数创建流对象
        FileOutputStream fos =new FileOutputStream("data3.txt",true);

        //1.写入字节
        fos.write(120);
        fos.write(0x12345678);
        fos.write('x');
        fos.write('\n');
        //2.写入字节数组
        byte[]  b = "abcde".getBytes();
        fos.write(b);
        String s = "我今天真厉害，学了这么多";
        fos.write(s.getBytes());

        //3.写入指定长度的字节数组
        fos.write('\n');
        fos.write(s.getBytes(),6,6);
        fos.write('\n');
        //关闭资源
        fos.close();
    }
}
