package mysoketnet.UDP.UDPdemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSender {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象(快递公司)
        DatagramSocket socket =new DatagramSocket();//采用随意端口构造

        //2.打包数据
        String message ="开始学习网络编程!!";
        byte[] buf=message.getBytes();
        DatagramPacket dp =new DatagramPacket(buf,buf.length, InetAddress.getByName("127.0.0.1"),8888);

        //3.发送数据
        socket.send(dp);

        //释放资源
        socket.close();
    }
}
