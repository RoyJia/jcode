import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class AboutZonedDateTime {

    static DateTimeZone defaulDateTimeZone = DateTimeZone.getDefault();

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
    }
}