package mysoketnet.TCP.practice2;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
客户端：发送一条数据，接收服务端反馈的消息并打印
服务端：接收数据并打印，再给客户端反馈消息
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket =new Socket("127.0.0.1",7777);

        OutputStream outputStream = socket.getOutputStream();

        Scanner sc =new Scanner(System.in);

        outputStream.write(sc.nextLine().getBytes());

        //写出一个结束标记
        socket.shutdownOutput();
        //接收到服务端反馈的消息,并打印
        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr =new InputStreamReader(inputStream);
        int b;
        while((b=isr.read())!=-1){
            System.out.print((char) b);
        }

        socket.close();


    }
}
