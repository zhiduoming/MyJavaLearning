package IO.buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

public class BufferedReaderdemo {
    public static void main(String[] args) throws IOException {
        //创建一个BufferedReader对象，用于从文件中读取数据
        BufferedReader br =new BufferedReader(new FileReader("data.txt"));

        //按行读取文件内容并打印到控制台
        String line;
        while((line =br.readLine())!=null){
            System.out.println(line);
        }

        //关闭BufferedReader，释放资源
        br.close();
    }
}
