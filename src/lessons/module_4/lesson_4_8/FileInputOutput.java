package lessons.module_4.lesson_4_8;

import java.io.*;
import java.util.Scanner;

public class FileInputOutput {
    public static void main(String[] args) {
//        fileInputTest();
//        fileOutputTest();
        copy("pdp.txt","salom1.txt");
    }

    private static void copy(String source, String target) {
        InputStream in=null;
        OutputStream out=null;
        try{
            in=new FileInputStream(source);
            out=new FileOutputStream(target);

            int a;
            while((a= in.read())!=-1){
                out.write((char)(a));
            }

            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private static void fileInputTest() {
        InputStream in=null;
        try {
            in=new FileInputStream("test.txt");

//            while (in.available()>0){
//                System.out.print((char)in.read());
//            }

//            int a;
//            while((a= in.read())!=-1){
//                System.out.print((char)(a));
//            }

            Scanner sc=new Scanner(in);

//            while (sc.hasNext()) {
//                System.out.println(sc.nextLine());
//            }

            int a=sc.nextInt();
            System.out.println("a="+a);
            int b=sc.nextInt();
            System.out.println("b="+b);
            System.out.println(a+b);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
