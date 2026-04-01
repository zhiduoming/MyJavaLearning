package mysoketnet.TCP.practice3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        /*
        客户端:将本地文件上传到服务器,接收服务器的反馈(文件上传成功)
        服务端:接收客户端上传的文件,上传完毕之后给出反馈
         */
        ServerSocket ss =new ServerSocket(7777);
        System.out.println("---------------服务器启动,等待客户端连接---------------");

        Socket socket = ss.accept();
        System.out.println("客户端连接成功!!");
        //创建输入流来读取文件
        BufferedInputStream bis =new BufferedInputStream(socket.getInputStream());
        //生成随机文件名
        String name = UUID.randomUUID().toString().replace("-","");

        BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream("C:\\Code\\Java_Learning\\picture\\"+name+".png"));
        byte[] bytes =new byte[1024*1024*4];
        int len;
        while((len=bis.read(bytes))!=-1){
           bos.write(bytes,0,len);
        }
        //创建输出流来发出反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("文件接收成功".getBytes());

        //释放资源
        bos.close();
        bis.close();
        socket.close();
        ss.close();

    }
}
