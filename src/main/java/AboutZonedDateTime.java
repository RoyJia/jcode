import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

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
    }
}