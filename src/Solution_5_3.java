import java.util.List;
import java.util.stream.Collectors;

// 5.3 Collectors in practice: the product of squares
// https://stepik.org/lesson/35859/step/1?unit=15021
public class Solution_5_3 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        // 1*1 * 2*2 * 3*3 * 4*4 * 5*5 * 6*6 = 518_400

        long val = numbers.stream()
                //.map(a -> a * a)
                //.reduce(1, (a, b) -> a * b);
                .collect(Collectors.reducing(1, a->a*a, (a, b)-> a*b));

        System.out.println(val);

        /*
            Не соответствует условию задачи, но тем не менее напишем
            коллектор руками:

            <R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);


        Supplier<long[]> supplier = () -> {
            long[] arr = new long[1];
            arr[0] = 1;
            return arr;
        };
        BiConsumer<long[], Integer> accumulator = (a, b) -> {
            a[0]=a[0]*b*b;
        };
        BiConsumer<long[], long[]> combiner = (a, b) -> a[0]=a[0]*b[0];

        long val = numbers.stream()
            .collect(supplier, accumulator, combiner)[0];

        Это работает, но возвращаем мы массив, а нужно Long.

         */
    }
}
