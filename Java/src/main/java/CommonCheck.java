import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        CommonCheck commonCheck = new CommonCheck();
        System.out.println(commonCheck.index);
        System.out.println(last);

        System.out.println();

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