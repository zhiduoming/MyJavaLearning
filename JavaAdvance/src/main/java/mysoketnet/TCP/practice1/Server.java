package mysoketnet.TCP.practice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /*
        接收多次数据并打印
         */
        System.out.println("=== 服务器启动，等待客户端连接 ===");
        //创建ServerSocket对象,并绑定端口
        ServerSocket ss =new ServerSocket(7777);

        //监听连接请求
        Socket socket = ss.accept();
        System.out.println("客户端连接成功");
        //接收数据
        BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int len;
        char[] buf =new char[1024];
        while((len=br.read(buf))!=-1){
            System.out.print(new String(buf,0,len));
            System.out.println();
        }

        //关闭资源
        br.close();
        socket.close();
        ss.close();
    }
}
