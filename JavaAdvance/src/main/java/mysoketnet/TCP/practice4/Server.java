package mysoketnet.TCP.practice4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /*
        客户端:将本地文件上传到服务器,接收服务器的反馈(文件上传成功)
        服务端:接收客户端上传的文件,上传完毕之后给出反馈
         */
        ServerSocket ss =new ServerSocket(7777);
        System.out.println("---------------服务器启动,等待客户端连接---------------");


        while (true) {

            Socket socket = ss.accept();

            MyRun mr =new MyRun(socket);

            new Thread(mr).start();
        }



    }
}
