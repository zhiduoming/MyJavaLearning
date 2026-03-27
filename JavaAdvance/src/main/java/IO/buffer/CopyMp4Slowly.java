package IO.buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyMp4Slowly {
    public static void main(String[] args) {
        //记录开始时间
        long start=System.currentTimeMillis();

        //创建流对象
        try(FileInputStream fis =new FileInputStream("game.mp4");
             FileOutputStream fos =new FileOutputStream("copy.mp4")){

            //读写数据
            int b;
            while((b=fis.read())!=-1){
                fos.write(b);
            }
            //记录结束时间
            long end =System.currentTimeMillis();
            System.out.println("普通流复制是时间："+(end -start)+"毫秒");//普通流复制是时间：40494毫秒
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
