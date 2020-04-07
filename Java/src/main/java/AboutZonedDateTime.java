import java.time.ZonedDateTime;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class AboutZonedDateTime {

    static DateTimeZone defaulDateTimeZone = DateTimeZone.getDefault();
    static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) {
        DateTime current = new DateTime();
        String monthText = current.monthOfYear().getAsText(Locale.UK);
        System.out.println((monthText.length() > 3 ? monthText.substring(0, 3) : monthText) + " " + current.getYear());

        System.out.println(ZonedDateTime.now() + "----------------------------------------------------");

        String dateMonth = "201907";
        System.out.println(java.lang.String.format("%s年%s月", dateMonth.substring(0, 4), dateMonth.substring(4)));
        
        System.out.println(new java.lang.StringBuilder("201907").insert(4, "年").insert(7, "月").toString());
    }
}