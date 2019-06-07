import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class AboutZonedDateTime {

    static DateTimeZone defaulDateTimeZone = DateTimeZone.getDefault();
    static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) {
        System.out.println(defaulDateTimeZone.toString());

        // create an object of ZonedDateTime with time start of day
        ZoneId zoneId = ZoneId.of(defaulDateTimeZone.getID());
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId).plusDays(10).toLocalDate().atStartOfDay(zoneId);

        System.out.println(zonedDateTime.toString());

        ZoneId londaonZoneId = ZoneId.of("Europe/London");
        ZonedDateTime londonZonedDateTime = zonedDateTime.toLocalDate().atStartOfDay(londaonZoneId);
        ZonedDateTime londonZonedDateTime2 = zonedDateTime.withZoneSameInstant(londaonZoneId);

        System.out.println("londonZonedDateTime = " + londonZonedDateTime.toString());
        System.out.println("londonZonedDateTime2 = " + londonZonedDateTime2.toString());

        DateTime dateTime = new DateTime(new Date().getTime() + (3600 * 24 * 1000));

        System.out.println(dateTime.toString());


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 5);
        System.out.println(new DateTime(calendar));
        System.out.println(ZonedDateTime.now());


        System.out.println("2019-05-22T19:36:42.368-11:00");

        ZonedDateTime curreZonedDateTime = ZonedDateTime.now();
        System.out.println(curreZonedDateTime.plusDays(10).toString());
        System.out.println(curreZonedDateTime.plusDays(13).toString());

        System.out.println(new DateTime().plusMonths(1).toString("yyyyMMdd"));

        System.out.println(new Date().toString());

        System.out.println(ZonedDateTime.of(2020, 7, 12, 3, 0, 0, 0, ZoneId.systemDefault()));

        DateTime startDateTime = DateTime.now();
        DateTime endDateTime = startDateTime.plusMinutes(16);

        long mills = endDateTime.getMillis() - startDateTime.getMillis();
        System.out.println(mills % 900000);

        System.out.println("--------------------------------");

        Integer datestr = Integer.valueOf("20190605");

        DateTime dateTime2 = DateTime.parse(datestr.toString(), dateTimeFormatter);
        System.out.println(dateTime2.toString());

    }
}