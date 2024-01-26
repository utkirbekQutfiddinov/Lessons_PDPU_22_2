package lessons.module_4.lesson_4_7;

import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
//        Calendar cal=new GregorianCalendar();
        Calendar cal=Calendar.getInstance();
        System.out.println(cal.getTime());


//        cal.add(1,1);//year
//        cal.add(2,3);//month
//        cal.add(3,5);//week
//         cal.add(4,5);//day
//        cal.add(5,12);//day
//        cal.set(5,33)
//        cal.roll(5,20);
        System.out.println(cal.getTime());

    }
}
