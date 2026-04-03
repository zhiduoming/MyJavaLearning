package IO.serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamDemo {
    public static void main(String[] args) {
        Person p =new Person( "zhangsan",20);
        try{
            ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("person.dat"));
            oos.writeObject(p);
            oos.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
