package Oop.APIdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexdemo {

    public static void main(String[] args) {
        String str ="Java自从95年问世以来，经历了很多版本，abbbbbbbbbbbbbbbbaaaaa,目前企业中用的最多的是Java8和Java11，"+
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会登上历史舞台";
        String regex1="Java\\d{0,2}";
        String regex2="Java(?=8|11|17)";
        String regex3= "Java(?:8|11|17)";
        String regex4 ="Java(?!8|11|17)";
        String regex5="ab+?";
        Pattern p =Pattern.compile(regex5);
        Matcher matcher = p.matcher(str);
        while(matcher.find()){
            String s =matcher.group();
            System.out.println(s);
        }

    }
}
