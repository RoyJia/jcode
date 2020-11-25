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
        System.out.println(LocalDateTime.now().minusDays(29).toLocalDate().atStartOfDay());

        List<Integer> newList = null;
        if (newList.isEmpty()) {
            System.out.println("list is null");
        }

        System.out.println(new java.sql.Date(System.currentTimeMillis()+ (long)24*60*60*1000*30));
        System.out.println(System.currentTimeMillis() + 24*60*60*1000*30);
        System.out.println((long)24*60*60*1000*30);

        LocalDateTime dateTime1111 = LocalDateTime.now();
        System.out.println(dateTime1111.toString());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(11, 1);
        map.put(22, 2);
        List<Integer> list = Arrays.asList(11, 22, 33, 44, 55);
        List<Integer> result = list.stream().filter(i -> {
            map.put(i, map.getOrDefault(i, 0) + 1);
            return map.get(i) < 3;
        }).collect(Collectors.toList());

        System.out.println(result.toString());

        int code = new Random().nextInt(900000) + 100000;
        Date date = new Date();
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("GMT"));
        LocalDateTime sgTime = LocalDateTime.now();
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        long ts1 = date.getTime();
        long ts2 = dateTime.toEpochSecond(ZoneOffset.UTC);

        Map<String, Integer> map1 = new ConcurrentHashMap<>();

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 9, 6, 5);

        List<Integer> list3 = list1.stream().filter(i -> !list2.contains(i)).collect(Collectors.toList());

        list3.stream().forEach(System.out::println);
    }

    public void doSomething() throws Exception {
        throw new Exception("adfadfadfadfa");
    }
}