package classwork.dateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class DateExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = new Date();
//        System.out.println(sdf.format(date));

        System.out.println("Please input your birthday (01-10-2000)");
        String dateStr = scanner.next();
        try {
            Date parse = sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Your date is not correct !!!!"  + e );
        }

    }
}
