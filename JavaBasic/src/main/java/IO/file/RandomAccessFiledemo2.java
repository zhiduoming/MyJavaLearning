package IO.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFiledemo2 {
    public static void main(String[] args) {
        File file =new File("data1.txt");
        //创建RandomAccessFile对象，并给出文件对象和模式
        try(RandomAccessFile raf =new RandomAccessFile(file ,"rw" )){
            //写入文件
            raf.writeUTF("今天是个好日子\n");

            //移动指针位置到开头
            raf.seek(0);

            //读取文件
            System.out.println("内容："+raf.readUTF());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
