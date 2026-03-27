package IO.buffer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamdemo {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream("data.txt",true));

        //创建一个字节数组，作为缓冲区
        byte[] buffer =new byte[1024];

        //将数据写入文件
        String data ="今天是个好日子，我开始学习IO流了\n";
        buffer =data.getBytes();
        bos.write(buffer);

        bos.flush();;
        bos.close();
    }
}
