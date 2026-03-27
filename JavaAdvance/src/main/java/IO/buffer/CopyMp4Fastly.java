package IO.buffer;

import java.io.*;

public class CopyMp4Fastly {
    public static void main(String[] args) {
        //记录开始时间
        long start = System.currentTimeMillis();

        //创建流对象
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("game.mp4"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copyfast.mp4"))) {
            //读写操作
            int b;
            byte[] bytes =new byte[8*1024];
            while ((b = bis.read(bytes)) != -1) {
                bos.write(bytes,0,b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("缓冲流复制时间：" + (end - start) + "毫秒");//output：缓冲流复制时间：126毫秒（使用单个字节复制）
                                                                    //output:缓冲流复制时间：17毫秒(使用数组复制)

    }
}
