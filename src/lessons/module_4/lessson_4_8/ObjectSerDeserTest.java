package lessons.module_4.lessson_4_8;

import java.io.*;

public class ObjectSerDeserTest {
    public static void main(String[] args) throws Exception{

        BookTest bookTest=new BookTest("Java in action"," Jochua Bloch");
        System.out.println(bookTest);

        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("book.ser"));
        out.writeObject(bookTest);

        ObjectInputStream in=new ObjectInputStream(new FileInputStream("book.ser"));

        BookTest book =(BookTest) in.readObject();
        System.out.println(book);
    }
}
