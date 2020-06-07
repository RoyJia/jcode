package common_check;

public class NineNineMultiplication {
    public static void main(String[] args) {
        for (int i=1; i<10; i++) {
            for (int j=1; j<=i; j++) {
                System.out.printf("%d * %d = %d\t", j, i, j*i);
            }
            System.out.println();
        }
    }
}
