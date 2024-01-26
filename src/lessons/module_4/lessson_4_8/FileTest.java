package lessons.module_4.lessson_4_8;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
//        File file=new File("PDP.java");
//        file.delete();
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        boolean b = file.renameTo(new File("Java.java"));
//        if (b){
//            System.out.println("Success");
//        }else{
//            System.out.println("error");
//        }
        File file=new File("src3/f1/f2");

//        System.out.println(file.isDirectory());
//        String[] files=file.list();

//        for (int i = 0; i < files.length; i++) {
//            System.out.println(files[i]);
//        }



//        recursiveEntering(file,2);

//        file.mkdirs();



    }

    private static void recursiveEntering(File file, int tabsCount) {
        File[] files=file.listFiles();


        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < tabsCount; j++) {
                System.out.print("\t");
            }
            System.out.println(files[i].getName());
            if(files[i].isDirectory()){
//                for (int j = 0; j < tabsCount; j++) {
//                    System.out.print("\t");
//                }
                recursiveEntering(files[i],tabsCount+2);
            }
        }
    }
}
