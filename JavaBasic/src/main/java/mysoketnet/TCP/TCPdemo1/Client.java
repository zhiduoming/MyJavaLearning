package mysoketnet.TCP.TCPdemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //TCP协议,发送数据
        //创建Socket对象
        Socket socket =new Socket("127.0.0.1",10002);//指定端口

        //获取输出流
        OutputStream outputStream = socket.getOutputStream();

        //写出数据
        outputStream.write("你好你好TCP".getBytes());

        //释放资源
        outputStream.close();
        socket.close();
    }

}
