import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 4.5 Bad words detecting
// https://stepik.org/lesson/35217/step/1?unit=14575
public class Solution_14575_1 {

    public static void main(String[] args) {
        String text = "1 2 3 4 5 6 7 1 1 1 1 1";
        List<String> badWords = List.of("9", "8", "1", "3", "2", "1");
        List<String> badWordsInText = createBadWordsDetectingStream(text, badWords)
                .collect(Collectors.toList());
        System.out.println(badWordsInText);
    }


    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        // All words in the text are divided by whitespaces
        // (always only one whitespace between two words).
        Set<String> allWords = new HashSet<>(Arrays.asList(text.split("\\s")));

        // return the list of bad words which were found in the text.
        // The result should be dictionary ordered (in lexicographical order, i.e. sorted)
        // and bad words shouldn't repeat
        return badWords.stream()
                .distinct() // dont check Stepik
                .filter(allWords::contains)
                .sorted();
    }
}
