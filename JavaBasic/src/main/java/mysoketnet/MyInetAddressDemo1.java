package mysoketnet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        //获取InetAddress的对象
        //相当于获得一个电脑的对象
        InetAddress address = InetAddress.getByName("LAPTOP-VOVHU4AU");
        System.out.println(address);  //output: LAPTOP-VOVHU4AU/192.168.81.1

        //获取此IP地址的主机名
        String hostName = address.getHostName();
        System.out.println(hostName);

        //返回IP地址字符串
        String hostAddress = address.getHostAddress();
        System.out.println(hostAddress);
    }
}
