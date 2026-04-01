package mysoketnet.UDP.UDPdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象
        DatagramSocket socket =new DatagramSocket(10086);//与接收端指定端口相一致

        //2.接收包裹
        byte[] bytes=new byte[1024];
        DatagramPacket dp =new DatagramPacket(bytes,bytes.length);

        while (true) {
            socket.receive(dp);
            //3.解析包裹
            InetAddress address = dp.getAddress();
            byte[] data = dp.getData();
            int length = dp.getLength();
            int port = dp.getPort();
            System.out.println("接收到数据:"+new String(data,0,length));
            System.out.println("该数据是由"+address+"这台电脑中的"+port+"端口发送的");
        }


    }
}
