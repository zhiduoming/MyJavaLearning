package Oop.APIdemo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class APIBigInteger {

    public static void main(String[] args) {

        //获取一个随机的大整数[0~2的6次方-1]
        /*for (int i = 0; i < 100; i++) {
            BigInteger bigInteger =new BigInteger(10,new Random());
            System.out.println(bigInteger);
        }*/
        //获取一个指定的大整数
        /*BigInteger bigInteger =new BigInteger("99999999999999999999999999999999999999999");
        System.out.println(bigInteger);*/
        //获取一个指定进制的大整数
        //字符串中的整数必须和进制相吻合
        /*BigInteger bigInteger =new BigInteger("111111111",2);
        System.out.println(bigInteger);*/

        //只能在long的取值范围之内
        BigInteger bigInteger = BigInteger.valueOf(101191934594L);
        System.out.println(bigInteger);
        BigDecimal bigDecimal =new BigDecimal("1.11111111111111111111141414141414");
        BigDecimal bigDecimal2 =new BigDecimal("1.11111111111111111111141414141415");

        System.out.println(bigDecimal.divide(bigDecimal2,2, RoundingMode.HALF_UP));
    }
}
