import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class CommonCheck {

    public static void main(String[] args) {
        String str = "0028|ggg|ggg|";
        List<String> list = Arrays.asList(str.split("\\|"));
        list = new ArrayList<String>(list);
        if (list.size() == 3) {
            list.add("");
        }

        list.forEach(System.out::println);

        System.out.println(list.getClass());
    }
}