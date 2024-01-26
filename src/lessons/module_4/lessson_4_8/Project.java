package lessons.module_4.lessson_4_8;

import java.io.File;
import java.util.Scanner;

public class Project {
    static String currentPath="C:/";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String cmd="";

        while(!cmd.equals("exit")&&!cmd.equals("quit")){
            System.out.print(currentPath+">");
            cmd=sc.nextLine();
            switch (cmd){
                case "dir"->{
                    showDirectoryFiles(currentPath);
                }
                default -> {
                    if(cmd.startsWith("cd ")){
                        if(cmd.endsWith("../")){
                            //C:/users/user/windows/java/pdp

                            int lastIndex=currentPath.lastIndexOf("/");
                            currentPath=currentPath.substring(0,lastIndex);

                        }else{

                            //"cd Users"
                            String path = cmd.split(" ")[1];
                            currentPath=currentPath+"/"+path;
                        }


                    }
                }
            }
        }
        System.out.println("Good bye");
    }

    private static void showDirectoryFiles(String path) {
        File file=new File(path);

        String[] fileNames=file.list();
        for (int i = 0; i < fileNames.length; i++) {
            System.out.println(fileNames[i]);
        }
    }
}
