package mysoketnet.TCP.practice2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        /*
        客户端：发送一条数据，接收服务端反馈的消息并打印
        服务端：接收数据并打印，再给客户端反馈消息
        */
        System.out.println("----------服务器启动,等待客户端连接-----------");
        ServerSocket ss = new ServerSocket(7777);

        Socket socket = ss.accept();
        System.out.println("客户端连接成功");
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int b;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }
        //给客户端反馈消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("到底有多开心".getBytes());


        br.close();
        ss.close();
        socket.close();
    }
}
