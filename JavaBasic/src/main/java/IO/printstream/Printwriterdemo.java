package IO.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Printwriterdemo {
    public static void main(String[] args) {
        //用PrintWriter包装控制台
        PrintWriter out =new PrintWriter(System.out ,true);
        out.println("这行会不会打印到控制台上？");
        //用PrintWriter来给文件作打印
        try {
            PrintWriter  pw =new PrintWriter(new FileWriter("data6.txt",true),true  );
            pw.println("文件里面打印这行了吗");
            //刷新缓冲区
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
