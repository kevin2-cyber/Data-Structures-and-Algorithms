public class Recursion {
    public static void main(String[] args) {
        Recursion num = new Recursion();
        System.out.println(num.sum(9));
    }

    public int sum(int num) {
        int result;
        if (num == 1)
            result = 1;
        else
            result = num + sum(num -1);
        return result;
    }
}
