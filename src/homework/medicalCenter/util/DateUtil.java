package homework.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

    private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public static Date formatStringToDate(String dateStr) throws ParseException {
        return SDF_TIME.parse(dateStr);
    }

    public static String formatDateToString(Date date) {
        return SDF_TIME.format(date);
    }
}
