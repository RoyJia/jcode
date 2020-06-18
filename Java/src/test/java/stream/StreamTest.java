package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void testFlatMapOfStream() {
        List<List<String>> listList = Arrays.asList(
                Arrays.asList("Java", "JVM"),
                Arrays.asList("Bash", "Linux"),
                Arrays.asList("Python", "Interpreter")
        );

        List<String> strings = listList.stream().flatMap(Collection::stream).collect(Collectors.toList());

        strings.stream().forEach(System.out::println);
    }
}
