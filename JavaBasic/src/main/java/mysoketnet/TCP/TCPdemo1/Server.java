package mysoketnet.TCP.TCPdemo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //TCP协议 ,接收数据

        //创建ServerSocket对象
        ServerSocket  serverSocket =new ServerSocket(10002);

        //监听客户端的连接
        Socket socket = serverSocket.accept();//返回的对象是客户端的连接对象

        //从连接通道中获取输入流读取数据
        BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
        while((b=br.read())!=-1){
            System.out.print((char) b);
        }

        //释放资源
        socket.close();//断开和客户端的连接
        serverSocket.close();//关闭了服务器

    }
}
