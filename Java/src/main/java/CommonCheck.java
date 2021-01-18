import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonCheck {
    
    int index;
    static int last;

    {
        System.out.println("this is for instance data initialize");
        index = 100;
    }

    static {
        System.out.println("this is for class data initialize");
        last = 30;
    }

    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(0).divide(BigDecimal.valueOf(120), 2, RoundingMode.CEILING).multiply(BigDecimal.valueOf(100)).intValue());
    }

    public void doSomething() throws Exception {
        throw new Exception("adfadfadfadfa");
    }

    public static void addInt(int type) {
        type = 2;
    }
}