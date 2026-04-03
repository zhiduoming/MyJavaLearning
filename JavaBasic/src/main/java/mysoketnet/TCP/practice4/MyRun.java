package mysoketnet.TCP.practice4;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRun implements Runnable{

    Socket socket;

    public MyRun(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            System.out.println("客户端连接成功!!");


            //生成随机文件名
            String name = UUID.randomUUID().toString().replace("-","");

            BufferedOutputStream bos =new BufferedOutputStream(new FileOutputStream("C:\\Code\\Java_Learning\\picture\\"+name+".png"));

            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());


            byte[] bytes =new byte[1024*1024*4];
            int len;
            while((len=bis.read(bytes))!=-1){
                bos.write(bytes,0,len);
            }

            bos.close();
            //创建输出流来发出反馈
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("文件接收成功".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
