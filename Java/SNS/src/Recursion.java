public class Recursion {
    public static void main(String[] args) {
        int number = 10;
        int result = sum(number);

        System.out.println("Sum of numbers from 1 to " + number + " is: " + result);
    }

    public static int sum(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num + sum(num - 1);
        }
    }
}
