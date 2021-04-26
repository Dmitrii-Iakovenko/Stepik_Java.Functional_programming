import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 5.4 Collectors in practice: partitioning words into groups
// https://stepik.org/lesson/36410/step/1?unit=15454
public class Solution_5_4 {
    public static void main(String[] args) {
        String[] words = {"level", "make", "todo", "ololo"};
        Map<Boolean, List<String>> palindromeOrNoMap = Arrays.stream(words)
                .collect(Collectors.partitioningBy(str->str.equals(new StringBuilder(str).reverse().toString())));
        System.out.println(palindromeOrNoMap);
    }
}
