package mysoketnet.UDP.UDPdemo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket对象
        //接收的端口必须手动绑定,并且和发送端要保持一致
        DatagramSocket socket = new DatagramSocket(8888);

        //2.接收数据包
        byte[] bytes =new byte[1024];
        DatagramPacket dp =new DatagramPacket(bytes,bytes.length);
        socket.receive(dp);

        //3.解析数据包
        byte[] data = dp.getData();
        int length = dp.getLength();
        int port = dp.getPort();
        InetAddress address = dp.getAddress();
        System.out.println("接收到数据:"+new String(data,0,length));
        System.out.println("该数据是由"+address+"这台电脑中的"+port+"端口发送的");

        //4.释放资源
        socket.close();
    }
}
