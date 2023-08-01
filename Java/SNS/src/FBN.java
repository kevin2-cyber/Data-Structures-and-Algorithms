public class FBN {
    public static long fibonacci(int n) {
        long[] memo = new long[n + 1];
        return fibonacciHelper(n, memo);
    }

    private static long fibonacciHelper(int n, long[] memo) {
        if (n <= 1)
            return n;

        if (memo[n] != 0)
            return memo[n];

        long fib = fibonacciHelper(n - 1, memo) + fibonacciHelper(n - 2, memo);
        memo[n] = fib;
        return fib;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(9));
    }
}
