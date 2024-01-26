package lessons.module_4.lesson_4_7;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class CalendarProject {

    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

//        int inYear = sc.nextInt();
//        int inMonth = sc.nextInt();
//        int inDay = sc.nextInt();

//        LocalDate date = LocalDate.of(inYear, inMonth, inDay);
//        LocalDate date = LocalDate.now();

        LocalDate date = LocalDate.of(2004, 7, 3);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        System.out.println(dayOfWeek + ", " + date.getMonth().name() + " " + date.getDayOfMonth());
        System.out.println("______________________");

        System.out.println(date.getMonth().name() + " " + date.getYear());

        DayOfWeek[] days = DayOfWeek.values();

        for (int i = 0; i < days.length; i++) {
            System.out.print(days[i].name().substring(0, 2) + " ");
        }
        System.out.println();

        int firstDayOfThisMonth = LocalDate.of(date.getYear(), date.getMonth(), 1)
                .getDayOfWeek()
                .getValue();


//        for (int i = 0; i < firstDayOfThisMonth - 1; i++) {
//            System.out.printf("%3s"," ");
//        }

        LocalDate prevDate = date.minusMonths(1);

        for (int i = prevDate.lengthOfMonth() - firstDayOfThisMonth + 2; i <= prevDate.lengthOfMonth(); i++) {
            System.out.print(RED + i + " " + RESET);
        }


        int daysCount = date.lengthOfMonth();

        for (int i = 1; i <= daysCount; i++) {
            System.out.print(GREEN + (i > 9 ? (i) : (" " + i)) + " " + RESET);
            if ((i + firstDayOfThisMonth - 1) % 7 == 0) {
                System.out.println();
            }
        }


        LocalDate nextMonthFirstDay = LocalDate.of(date.plusMonths(1).getYear(), date.plusMonths(1).getMonth(), 1);

        DayOfWeek nextMonthFirstDayOfWeek = nextMonthFirstDay.getDayOfWeek();

        for (int i = 1; i <= 7 - nextMonthFirstDayOfWeek.getValue() + 1; i++) {
            System.out.print(RED + " " + i + " " + RESET);
        }


    }
}
