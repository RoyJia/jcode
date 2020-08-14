import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

        Map<String, Integer> map = new ConcurrentHashMap<>();

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 9, 6, 5);

        List<Integer> list3 = list1.stream().filter(i -> !list2.contains(i)).collect(Collectors.toList());

        list3.stream().forEach(System.out::println);
    }
}