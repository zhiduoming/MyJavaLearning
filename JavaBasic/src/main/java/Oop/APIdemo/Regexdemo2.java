package Oop.APIdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Regexdemo2 {
    public static void main(String[] args) throws IOException {
        URL url =new URL("https://blog.xqmmcqs.com/");
        URLConnection conn =url.openConnection();
        BufferedReader br =new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;

        String regex="";

    }
}
