## 网络编程

**网络编程三要素**

**IP** :设备在网络中的地址,是唯一的标识

**端口号** :应用程序在设备中的唯一标识

**协议**: 数据在网络中传输的规则,常用协议有UDP、TCP、http、https、ftp



**IP**

全称(Internet Protocol),互联网协议地址，也称IP地址，是设备在网络中的地址，唯一标识



IPv4采用32位地址长度，分成四组，类似11000000 10101000 00000001 01000010，用点分十进制表示法可以表示为192.168.1.66，但总数量只有2^32(42亿)多，导致地址已耗尽所以后来使用IPv6。

IPv6采用128位地址长度，分成8组，形如：
<img src="images\image-20260401112359100.png" alt="image-20260401112359100" style="zoom: 33%;" />


其数量为2^128 ，基本上是使用不完的，采用冒分16进制表示法，例如上图中的地址可以标识为： 2001:0DB8:0000:0023:0008:0800:200C:417A  , 把其中的0省略后可以表示为： 2001:DB8:0:23:8:800:200C:417A



IP地址又分为公网 IP 地址和内网 IP 地址。公网 IP 地址可以直接被访问，内网 IP 地址只能在内网访问。内网 IP 地址类似于：

- 192.168.x.x
- 10.x.x.x

有一个特殊的 IP 地址，称之为本机IP，它永远之后寻找当前所在本机，它总是`127.0.0.1`。

两个常用的cmd命令

* ipconfig : 可以用来查看本机地址
<img src="images\image-20260401122002576.png" alt="image-20260401122002576" style="zoom:55%;" />

  

* ping：检查网络是否来连通（ping后面可以跟IP，也可以跟网址）
<img src="images\image-20260401122119588.png" alt="image-20260401122119588" style="zoom:50%;" />



Java中用来表示IP的类`InetAddress`

```java
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
```





**端口号**

端口号是应用程序在设备中的唯一标识，**一个端口号只能被一个应用程序使用**。

端口号是由两个字节表示的整数，取值范围是0~65535，其中0~1023之间的端口号用于一些知名的网络服务或者应用，我们只需要去使用1024以上的端口号



**协议**

OSI参考模型和TCP/IP模型：

OSI参考模型：世界互联协议标准，全球通信规范，但是模型过于理想化，未能在因特网上广泛推广

TCP/IP参考模型： 国际标准，广泛使用

<img src="images\image-20260401123430922.png" alt="image-20260401123430922" style="zoom:50%;" />
UDP协议：用户数据报协议（User Datagram Protocol），面向无连接通信协议（不管是否连接成功都会发送数据）  速度快，有大小限制，数据不安全，易丢失数据，适合语音通话，影音，网络会议等场景

TCP协议：传输控制协议（Transmission Control Protocol）,面向连接通信协议（必须要确保连接成功才能发送数据）速度慢，无大小限制，数据安全，不会丢失数据，适合文件下载，文字聊天，发送邮件等场景



**单播：** 一对一

在Java中实现UDP通信（单播）需要使用到两个类`DatagramSocket`（快递公司）和`DatagramPackage`（包裹）

具体代码实现如下：

发送端代码

```java
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
```

接收端代码：

```java
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
```

注意：**需要保证在发送端中指定的接收端口和在接收端中接收的端口相一致**，但是对于从发送端的哪个发送端口发出并不关心，且运行代码时，**需要先运行接收端，再运行发送端**，运行接收端之后，接收端处于阻塞状态



**组播：**一对多

代码与单播类似，但是需要将指定IP地址进行修改，换为组播地址，组播地址：`224.0.0.0`~`239.255.255.255`

> 注意：`224.0.0.0` ~ `224.0.0.255`：这部分是给路由器等底层网络设备预留的“VIP 专用群”，**千万别用**。我们在写代码测试时，通常会随手挑一个靠后的地址，比如 **`224.0.1.1`** 或者 **`239.0.0.1`** 作为我们的测试群号。

与单播不同：

1. **建站**：创建的对象需要进行改变，从原来单播的`DatagramSocket`变为`MulticastSocket`
2. **加群**：`socket.joinGroup(InetAddress.getByName("224.0.1.1"))`,这就相当于加入群聊，只有执行了这段代码，才能收到发往`224.0.1.1`中的数据



**广播：**对局域网中的所有设备发送数据

广播代码与单播极其类似，只需要将指定IP地址改为`255.255.255.255`,则在局域网中的所有设备都能接收到发送端发送的信息



**TCP协议**

Java中实现TCP协议的核心类是Socket 和ServerSocket类，其具体代码实现如下：

clinet（客户端）

```java
public class client {
    public static void main(String[] args) throws IOException {
        //TCP协议,发送数据
        //创建Socket对象
        Socket socket =new Socket("127.0.0.1",10002);//指定端口

        //获取输出流
        OutputStream outputStream = socket.getOutputStream();

        //写出数据
        outputStream.write("你好你好TCP".getBytes());

        //释放资源
        outputStream.close();
        socket.close();
    }
}
```

server（服务器）

```java
public class sever {
    public static void main(String[] args) throws IOException {
        //TCP协议 ,接收数据

        //创建ServerSocket对象
        ServerSocket  serverSocket =new ServerSocket(10002);

        //监听客户端的连接
        Socket socket = serverSocket.accept();//返回的对象是客户端的连接对象

        //从连接通道中获取输入流读取数据
        BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));//采用缓冲流和转换流来包装输入流，可以实现读取字符和提高读取速率的效果
        int b;
        while((b=br.read())!=-1){
            System.out.println((char) b);
        }//这里b获取的是读到的字符的数字码，所以打印时需要将其转回char类型，如果没读到就返回-1
        //释放资源
        socket.close();//断开和客户端的连接
        serverSocket.close();//关闭了服务器

    }
}
```



* `accept`方法返回的是客户端的连接对象，后续需要通过该连接对象获取输入流，对应方法是`getInputStream` 。

* 在创建ServerSocket对象时需要传入端口号，该端口号必须与客户端指定的端口相一致。
* 在与客户端建立连接的过程中，需要用到三次握手四次挥手的协议
* 在使用 TCP 传输文件时，客户端发完数据必须调用 shutdownOutput() 给服务端发送结束标记，否则服务端的 read() 会永远陷入死等阻塞





***三次握手与四次挥手***

**三次握手**：

**目的：确保连接成功**

1. 第一次握手： Client发送连接请求，Server被动监听
   * 报文内容：SYN=1，seq=x（SYN即`Synchronize`，同步，当SYN=1时，表示这是一个尝试建立连接的报文，seq即`Sequence Number`, 序号，是发送端的数据包序号，用来标记当前发送的数据在整个数据流中的位置，防止数据乱序）
2. 第二次握手：Server确认并发起连接请求
   * 报文内容：SYN=1 ，ACK=1，seq=y, ack=x+1 (ACK即Acknowlegment ,确认，当ACK=1时，表示确认收到了对方的数据，建立连接后，所有报文的ACK都必须为1，ack即Acknowlege Number ,确认号，期望收到对方下一个报文的序号)
3. 第三次握手：Client确认Server的请求
   * 报文内容：ACK=1 ，seq =x+ 1，ack=y+1（客户端收到了服务端的同步确认，客户端将ACK置为1，确认号ack设置为y+1表示收到了服务端的y，序号seq为x+1）



**四次挥手**：

**目的：确保连接断开，且数据处理完毕**

1. 第一次挥手：Client发送断开请求
   * 报文内容： FIN=1，seq=u（客户端停止发送数据，发送FIN报文，序列号为u，此时客户端进入半关闭状态，只能接收，不能发送）
2. 第二次挥手：Server确认Client的断开请求
   * 报文内容：ACK=1，seq=v，ack=u+1（服务端收到ACK进行确认，确认号ack为u+1，此时客户端到服务端的连接被释放，但是服务端可能还有尚未处理完的数据需要继续发送给客户端，所以服务端此时还不能立刻发送自己的FIN）
3. 第三次挥手：Server发送断开请求
   * 报文内容：FIN=1，ACK=1，seq=w，ack=u+1（服务端的所有数据也发送完毕了，底层调用 `close()`，向客户端发送 FIN 报文，请求关闭服务端到客户端方向的连接）
4. 第四次挥手：Client 确认 Server 的断开请求
   * 报文内容：ACK=1，seq=u+1，ack=w+1(客户端发送最后的 ACK 后，连接**并没有立刻彻底释放**，而是必须在 `TIME-WAIT` 状态等待 **2MSL**（Maximum Segment Lifetime，报文最大生存时间，通常为 1-4 分钟）
