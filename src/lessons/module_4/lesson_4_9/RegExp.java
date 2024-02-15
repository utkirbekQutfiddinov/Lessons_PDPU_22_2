package lessons.module_4.lesson_4_9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) throws Exception{



        /** count
         * X*: more than or equal to zero
         * x+: 1+
         * x?: 0,1
         * x{n}: n
         * x{n,}: at least n
         * x{n,m}: from n to m
         */

        /** meta
         * \d: digits
         * \D: non-digit
         * \w: word (a-zA-Z0-9_)
         * \W: ^\w
         * \s: space
         * \S: non space
         * \b: block
         */

        /** posix
         * \p{Digit}: \d
         * \p{Upper}: A-Z
         *
         *
         */

        /** classes
         * [0-9]:
         * [az]: a or z
         * [^az]: not a nor z
         * ^[az]:  start with a or z
         * [az]$:  end with a or z
         */


        /* grouping types:
         * 1) captured group: (pattern)
         * 2) non-captured group: (?:pattern)
         * 3) named group: (?<name>pattern)
         * 4) Positive lookahead: (?=pattern)
         * 5) negative lookahead: (?!pattern)
         * 6) positive lookbehind: (?<=pattern)
         * 7) negative lookbehind: (?<=pattern)
         */


    }

    private static void namedGroup() {
        Scanner sc=new Scanner(System.in);


        Pattern p=Pattern.compile("(?<kun>\\d{2})-(?<oy>\\d{2})-(?<yil>\\d{4})");

        Matcher m=p.matcher(sc.next());

        if(m.matches()){
            System.out.println("Year: "+m.group("yil"));
            System.out.println("Month: "+m.group("oy"));
            System.out.println("Day: "+m.group("kun"));
            System.out.println("Full: "+m.group(0));
        }
    }

    private static void nonCapturedGroup() {
        Scanner sc=new Scanner(System.in);


        Pattern p=Pattern.compile("(\\d{2})-(?:\\d{2})-(\\d{4})");

        Matcher m=p.matcher(sc.next());

        if(m.matches()){
            System.out.println("Year: "+m.group(2));
//            System.out.println("Month: "+m.group(2));
            System.out.println("Day: "+m.group(1));
            System.out.println("Full: "+m.group(0));
        }
    }

    private static void capturedGroup() {
        Scanner sc=new Scanner(System.in);


        Pattern p=Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");

        Matcher m=p.matcher(sc.next());

        if(m.matches()){
            System.out.println("Year: "+m.group(3));
            System.out.println("Month: "+m.group(2));
            System.out.println("Day: "+m.group(1));
            System.out.println("Full: "+m.group(0));
        }
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
