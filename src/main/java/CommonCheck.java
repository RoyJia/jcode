import org.apache.commons.lang3.Validate;

public class CommonCheck {

    public static void main(String[] args) {
        String aaa = null;

        Validate.notNull(aaa);
    }
}