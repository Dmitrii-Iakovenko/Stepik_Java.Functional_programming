import java.util.stream.LongStream;

// 4.9 The sum of odd numbers
// https://stepik.org/lesson/36144/step/1?unit=15253
public class Solution_4_9 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println(100_000_000 + " " + 200_000_000 + " = " + sumOfOddNumbersInRange(100_000_000, 200_000_000));
        System.out.println(System.currentTimeMillis()-time);

        time = System.currentTimeMillis();
        System.out.println(100_000_000 + " " + 200_000_000 + " = " + sumOfOddNumbersInRange2(100_000_000, 200_000_000));
        System.out.println(System.currentTimeMillis()-time);

        time = System.currentTimeMillis();
        System.out.println(100_000_000 + " " + 200_000_000 + " = " + sumOfOddNumbersInRange3(100_000_000, 200_000_000));
        System.out.println(System.currentTimeMillis()-time);

    }

    /**
     * The method calculates the sum of odd numbers in the given range
     *
     * @param start of a range, start >= 0
     * @param end of a range (inclusive), end >= start
     *
     * @return sum of odd numbers
     */
    public static long sumOfOddNumbersInRange(long start, long end) {
        // write your code here
        return LongStream
                .rangeClosed(start, end)
                .filter(x -> x%2 == 1)
                .sum();
    }

    public static long sumOfOddNumbersInRange2(long start, long end) {
        // first odd
        //start += 1 - start % 2;
        start = start % 2 == 0 ? start+1 : start;

        return LongStream
                .iterate(start, i-> i <= end, i->i+2)
                .sum();
    }

    public static long sumOfOddNumbersInRange3(long start, long end) {
        // first odd
        //start += 1 - start % 2;
        start = start % 2 == 0 ? start+1 : start;

        long sum = 0;
        for (long i = start; i <= end; i=i+2) {
            sum += i;
        }

        return sum;
    }





}
