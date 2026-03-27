package Oop.oop;

import java.util.Random;

public class Oop_demo_03 {
    public static void main(String[] args) {
        // 调用方法并打印结果
        String code = generateCode();
        System.out.println("生成的验证码是: " + code);
    }

    public static String generateCode() {
        // 1. 准备字母池 (a-z, A-Z)
        char[] letters = new char[52];
        for (int i = 0; i < 26; i++) {
            letters[i] = (char) ('a' + i);         // 存小写
            letters[i + 26] = (char) ('A' + i);    // 存大写
        }

        // 2. 使用 StringBuilder 拼接，效率更高
        StringBuilder result = new StringBuilder();
        Random r = new Random();

        // 3. 随机取4个字母
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(letters.length);
            result.append(letters[index]);
        }

        // 4. 随机生成最后一位数字并拼接
        result.append(r.nextInt(10));

        // 5. 转成字符串返回
        return result.toString();
    }
}