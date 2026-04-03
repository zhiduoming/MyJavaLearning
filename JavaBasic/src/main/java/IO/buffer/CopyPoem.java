package IO.buffer;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Pattern;

public class CopyPoem {
    public static void main(String[] args) throws IOException{
        //创建map集合，保存文本数据，键为序号，值为文字
        HashMap<String ,String >  lineMap = new HashMap<>();

        //创建流对象
        BufferedReader br =new BufferedReader(new FileReader("data.txt"));
        BufferedWriter bw =new BufferedWriter(new FileWriter("poem.txt",true));

        //读取数据
        String line;
        while((line=br.readLine())!=null){
            if(line.isEmpty()){
                continue;
            }
            String[] split =line.split(Pattern.quote("."));
            //保存到集合
            lineMap.put(split[0],split[1]);
        }
        br.close();

        for(int i=1;i<=lineMap.size();i++){
            String key = String.valueOf(i);
            //获取map中文本
            String value = lineMap.get(key);
            //写出拼接文本
            bw.write (key +"."+value);
            //换行
            bw.newLine();
        }
        bw.close();

    }
}
