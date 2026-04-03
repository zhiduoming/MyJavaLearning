package Oop.extends_demo2;

public class TestDog {
    public static void main(String[] args) {
        Husky h =new Husky();
        Sharpei sp=new Sharpei();
        ChineseDog cd =new ChineseDog();

        //Husky
        h.eat();
        h.breakHome();
        h.drink();
        h.lookHome();
        System.out.println("-------------------------------");
        //sharpei
        sp.eat();
        sp.drink();
        sp.lookHome();
        System.out.println("--------------------------------");
        //ChineseDog
        cd.eat();
        cd.drink();
        cd.lookHome();
    }
}
