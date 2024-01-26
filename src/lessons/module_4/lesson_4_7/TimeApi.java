package lessons.module_4.lesson_4_7;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeApi {
    public static void main(String[] args) {
//      localDateTest();
//        localTimeTest();
//        localDateTime();
    }

    private static void localDateTime() {
        LocalDateTime dateTime=LocalDateTime.now();
        LocalDateTime dateTime1=LocalDateTime.of(2030,Month.JANUARY,23,14,23);
        LocalDateTime dateTime2=LocalDateTime.parse("2023/12/24 14:25:03",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println(dateTime2);
    }

    private static void localTimeTest() {
        LocalTime time=LocalTime.now();
        LocalTime tim1=LocalTime.of(12,56,23,123456678);
        System.out.println(time);
//        System.out.println(tim1);

        System.out.println(time.plusHours(1).plusMinutes(52).plusSeconds(59));

    }

    private static void localDateTest() {
        LocalDate date=LocalDate.now();

//        System.out.println(date.getDayOfWeek());

        LocalDate date1=LocalDate.of(2025, Month.JANUARY,26);
        LocalDate date2=LocalDate.parse("01.03.2056",DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println(date2.format(DateTimeFormatter.ofPattern("MM/yyyy/dd")));
//        System.out.println(date.isAfter(date1));
//        System.out.println(date.isBefore(date1));

        System.out.println(date);
        date = date.plusDays(12);

        System.out.println(date);

        date=date.minusDays(4);
        System.out.println(date);

        System.out.println(date.plus(Period.of(0,0, 3)));


    }
}
