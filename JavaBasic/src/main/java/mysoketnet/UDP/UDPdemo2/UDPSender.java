package mysoketnet.UDP.UDPdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        /*
         * 聊天室练习,发送端通过键盘录入来发送数据,直到接收到的数据是886才停止发送
         * 接收端采用死循环不断地接收数据
         */

        //1.创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();

        //2.打包数据
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("你输入的数据是:");
            String s = sc.nextLine();
            if("886".equals(s)){
                break;
            }

            byte[] data = s.getBytes();//将字符串转化为字节数组


            DatagramPacket dp = new DatagramPacket(data, data.length, InetAddress.getByName("127.0.0.1"), 10086);


            //3.发送数据
            socket.send(dp);
        }

        //4.关闭资源
        socket.close();

    }
}
