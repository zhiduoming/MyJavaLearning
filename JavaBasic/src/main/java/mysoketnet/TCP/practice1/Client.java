package mysoketnet.TCP.practice1;
    /*
    客户端：多次发送数据
    服务端：接收多次数据，并打印
     */

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        Socket socket =new Socket("127.0.0.1",7777);

        //获取输出流
        OutputStream outputStream = socket.getOutputStream();

        //多次写入数据
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("请输入您要发送的信息");
            String str =sc.nextLine();
            if("886".equals(str)){
                break;
            }
            outputStream.write(str.getBytes());

        }

        //关闭资源
        socket.close();

    }
}
