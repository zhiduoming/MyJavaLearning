package IO.characterstream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterdemo {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建流对象
        FileWriter fw =new FileWriter("data5.txt",true);

        //写入数据
        fw.write('刷');
        fw.flush();
        fw.write("新率");
        fw.flush();
        fw.write("真高啊");
        fw.write("今天是个好日子",2,5);
        fw.flush();
    }
}
