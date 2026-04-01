package mysoketnet.TCP.practice4;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        /*
        客户端:将本地文件上传到服务器,接收服务器的反馈(文件上传成功)
        服务端:接收客户端上传的文件,上传完毕之后给出反馈
         */

        //创建Socket对象
        Socket socket = new Socket("127.0.0.1", 7777);
        //创建输出流
        OutputStream outputStream = socket.getOutputStream();
        //创建文件输入流来读取文件内容
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Code\\Java_Learning\\picture\\img.png"));
        int b;
        while ((b = bis.read()) != -1) {
            outputStream.write(b);
        }

        //设置结束标记
        socket.shutdownOutput();

        //创建输入流来读取反馈信息
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        //释放资源
        socket.close();
        bis.close();
    }
}
