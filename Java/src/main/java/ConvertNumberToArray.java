
public class ConvertNumberToArray {

    public static void main(String[] args) {
        int x = -123;
        StringBuilder result = new StringBuilder(x < 0 ? "-" : "");
        int temp = x;

        do{
            result.append(temp % 10);
            temp /= 10;
        } while(temp != 0);

        System.out.println(Integer.parseInt(result.toString()));
    }

}