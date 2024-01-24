package lessons.module_4.lesson_4_7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCalendar {
    public static void main(String[] args) {
        Date date=new Date();

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:ss:mm");//dd-MM-yyyy

        Date date1=new Date();
        try {
            date1=sdf.parse("11-10-2025 16:15:12");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date.before(date1)) {
            System.out.println("date is before date1");
        }else {
            System.out.println("date is after date1");
        }

        String str=sdf.format(new Date());

        System.out.println(str);

    }
}
