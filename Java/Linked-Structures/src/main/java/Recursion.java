public class Recursion {
    public static void main(String[] args) {
        int num = sum(9);
        System.out.println(num);
    }

    public static int sum(int num) {
        int result;
        if (num == 1)
            result = 1;
        else
            result = num + sum(num -1);
        return result;
    }
}
