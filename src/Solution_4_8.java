import java.util.stream.LongStream;

// 4.8 Calculating a factorial
// https://stepik.org/lesson/35849/step/1?unit=15014
public class Solution_4_8 {
    public static void main(String[] args) {
        System.out.println(0 + " " +  factorial(0));
        System.out.println(1 + " " +  factorial(1));
        System.out.println(2 + " " +  factorial(2));
        System.out.println(3 + " " +  factorial(3));
        System.out.println(4 + " " +  factorial(4));
        System.out.println(5 + " " +  factorial(5));
    }


    /**
     * Calculates the factorial of the given number n
     *
     * @param n >= 0
     *
     * @return factorial value
     */
    public static long factorial(long n) {
        // write your code here
        return LongStream
                .rangeClosed(2, n)
                .reduce((a, b) -> a * b).orElse(1);
    }
}
