package IO.buffer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bufferedwriterdemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw =new BufferedWriter(new FileWriter("data.txt",true));

        //将数据写入文件
        String data="我怎么这么帅气";
        bw.write(data);
        bw.newLine();

        //刷新缓冲区，将缓冲区的数据写入到文件中
        bw.flush();

        bw.close();
    }
}
