import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 4.6 Numbers filtering
// https://stepik.org/lesson/36158/step/1?unit=15266
public class Solution_4_6 {
    public static void main(String[] args) {
        IntStream evenStream = IntStream.of(2, 4, 6, 8, 10, 30, 60);
        IntStream oddStream  = IntStream.of(3, 5, 7, 9, 11, 15, 75);
        List<Integer> list = createFilteringStream(evenStream, oddStream)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    // Create the third stream that contains numbers from both streams which is divisible by 3 and 5.
    // After calling collect(Collectors.toList()) the stream should return sorted list (ascending)
    // of these numbers. Two first suitable numbers in the sorted list must be skipped.
    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream)
                .filter(x -> x % 15 == 0)
                .sorted()
                .skip(2);
    }

}
