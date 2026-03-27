package IO.file;

import java.io.File;

/**
 * 获取功能的方法
 */
public class Filedemo1 {
    public static void main(String[] args) {
        File f =new File("C:\\Code\\Java_Learning\\JavaAdvance\\src\\main\\java\\IO\\file\\testfile.txt");
        System.out.println("文件的绝对路径："+f.getAbsolutePath());
        System.out.println("文件的构造路径："+f.getPath());
        System.out.println("文件名称："+f.getName());
        System.out.println("文件长度："+f.length()+"字节");

        File f2 =new File("C:\\Code\\Java_Learning\\JavaAdvance\\src\\main\\java\\IO\\file");
        System.out.println("目录绝对路径:"+f2.getAbsolutePath());
        System.out.println("目录构造路径:"+f2.getPath());
        System.out.println("目录名称:"+f2.getName());
        System.out.println("目录长度:"+f2.length());
    }
}
