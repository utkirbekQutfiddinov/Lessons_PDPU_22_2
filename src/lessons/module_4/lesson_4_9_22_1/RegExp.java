package lessons.module_4.lesson_4_9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) throws Exception{
//        regexOldTest();

        Scanner sc=new Scanner(System.in);

//        Pattern p=Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
//        Pattern p=Pattern.compile("(?:\\d{2})-(?:\\d{2})-(?:\\d{4})");
//        Pattern p1=Pattern.compile("(?<year>\\d{4})-(?<day>\\d{2})-(?<month>\\d{2})");
        Pattern p1=Pattern.compile("(?<div>\\w+</div>)");
        String text=sc.nextLine();
        Matcher matcher=p1.matcher(text);


        while (matcher.find()){
            System.out.println(matcher.group());
        }

//        int sum=0;
//        System.out.println(matcher.group(1));
//        while (matcher.find()) {
//            sum+=Integer.parseInt(matcher.group());
//        }
//
//
//        System.out.println(sum);

//        if(matcher.matches()){
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//            System.out.println(matcher.group(3));
//        }


    }

    private static void regexOldTest() throws IOException {
        String text=Files.readString(Path.of("yangi.txt"));
//        System.out.println(text);

        String[] words = text.split(" +");

        for(String word: words){
            System.out.println(word);
        }
    }
}
