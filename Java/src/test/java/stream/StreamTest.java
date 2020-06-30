package stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamTest {

    @Test
    public void testFlatMapOfStream() {
        List<List<String>> listList = Arrays.asList(
                Arrays.asList("Java", "JVM"),
                Arrays.asList("Bash", "Linux"),
                Arrays.asList("Python", "Interpreter")
        );

        List<String> strings = listList.stream().flatMap(Collection::stream).collect(Collectors.toList());

        // Note: stream operation does not change data source, strings
        strings.stream().forEach(e -> e = e+"hello");

        strings.stream().forEach(System.out::println);
    }

    @Test
    public void testStringToStream() {
        String str = "hello world";

        str.chars().forEach(System.out::println);

        Integer a = 1;
        int b = 1;
        assertEquals((int)a, b);
    }
}
