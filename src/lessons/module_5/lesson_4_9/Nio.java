package lessons.module_5.lesson_4_9;

import lessons.module_4.lessson_4_8.BookTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Nio {
    public static void main(String[] args) throws Exception {

//        reader();


//        path();


//        files();

//        serDeser();




    }

    private static void serDeser() throws IOException, ClassNotFoundException {
        BookTest book1=new BookTest("Java 11","Herbert Shildt");


        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("book.txt"));

        out.writeObject(new ArrayList<BookTest>(){{
            add(book1);
            add(book1);
        }});
        out.flush();

        ObjectInputStream in=new ObjectInputStream(new FileInputStream("book.txt"));

        List<BookTest> o =(List<BookTest>) in.readObject();

        for(BookTest book: o){
            System.out.println(book);
        }
    }

    private static void files() throws IOException {
        String text = Files.readString(Path.of("yangi.txt"));
        System.out.println(text);


        Files.copy(Path.of("yangi.txt"),Path.of("src/new.txt"),StandardCopyOption.REPLACE_EXISTING);


        Files.delete(Path.of("book.ser"));
        Files.move(Path.of("test.txt"),Path.of("src/test.txt"),StandardCopyOption.REPLACE_EXISTING);

        Files.createFile(Path.of("eski.txt"));
    }

    private static void path() {
        Path path = Path.of("src/pdpCopy.txt");
//        System.out.println(path.isAbsolute());
//
//        Path of = Path.of("U:\\00. Java\\02. PDP Groups\\BE-22-2\\Lessons_PDPU_22_2\\test.txt");
//        System.out.println(of.isAbsolute());

//        System.out.println(path.toAbsolutePath());
        Path parent = path.getParent();
        Path lessons = parent.resolve("lessons");

        System.out.println(lessons.toAbsolutePath());
    }

    private static void reader() throws IOException {
        //        FileReader reader=new FileReader("test.txt");
//
//        int a;
//
//        while ((a= reader.read())!=-1){
//            System.out.print((char)a);
//        }

//        FileWriter writer=new FileWriter("yangi.txt");
//
//        reader.transferTo(writer);
//
//        writer.flush();


//        FileOutputStream f = new FileOutputStream("test.txt", true);
//
//        f.write((char) 65);


        FileWriter writer = new FileWriter("test.txt");

        writer.write("alik");
        writer.append(" mashina");
        writer.flush();
    }
}
