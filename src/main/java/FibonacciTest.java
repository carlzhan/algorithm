public class FibonacciTest {

    public static void main(String args[]) {
        int fibonacci = fibonacci(2);
        System.out.println(fibonacci);
    }

    private static int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int fibOne = 1;
        int fibTow = 0;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = fibOne + fibTow;
            fibTow = fibOne;
            fibOne = fib;
        }
        return fib;
    }
}
