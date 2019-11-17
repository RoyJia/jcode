
public class ConvertNumberToArray {

    public static void main(String[] args) {
        int x = -123;
        String result = x < 0 ? "-" : "";
        int temp = x;

        do{
            result += temp % 10;
            temp /= 10;
        } while(temp != 0);

        System.out.println(Integer.parseInt(result));
    }

}