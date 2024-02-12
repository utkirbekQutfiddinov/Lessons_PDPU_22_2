package lessons.module_4.lesson_4_8;

import java.io.*;

public class FileReaderTest {
    public static void main(String[] args) throws Exception {
//        reader();

//        writer();

    }

    private static void writer() throws IOException {
        FileWriter writer=new FileWriter("test.txt");

        writer.append("salom");
        writer.write("alik");
        writer.flush();
        writer.close();
    }

    private static void reader() throws IOException {
        FileReader reader=new FileReader("test.txt");

        System.out.println((char)reader.read());
//        reader.transferTo()
    }
}
