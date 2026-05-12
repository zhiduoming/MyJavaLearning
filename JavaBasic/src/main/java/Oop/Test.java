package Oop;

public class Test {
    public static void main(String[] args) {
        try {

        }catch (ArithmeticException e){
            throw new ArithmeticException("算数异常") ;
        }finally {
            System.out.println("finally");
        }
    }
}
