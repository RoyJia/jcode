import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.joda.time.DateTimeZone;

public class AboutZonedDateTime {

    static DateTimeZone defaulDateTimeZone = DateTimeZone.getDefault();

    public static void main(String[] args) {
        System.out.println(defaulDateTimeZone.toString());

        // create an object of ZonedDateTime with time start of day
        ZoneId zoneId = ZoneId.of(defaulDateTimeZone.getID());
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId).plusDays(10).toLocalDate().atStartOfDay(zoneId);

        System.out.println(zonedDateTime.toString());
    }
}