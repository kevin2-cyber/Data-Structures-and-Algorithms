import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int[] numbers = {0,1,2,3,4,5,6,6,7,8,9};
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        // count through numbers
        for (int num : numbers) {
            if (num == number) {
                System.out.print("-> " + num + " <-");
                break;
            }
            System.out.print(num + ", ");
        }
    }
}