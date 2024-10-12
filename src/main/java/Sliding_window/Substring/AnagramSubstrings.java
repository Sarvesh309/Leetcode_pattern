package Sliding_window.Substring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramSubstrings {
    public static void main(String[] args) {
        String X = "XYYZXZYZXXYZ";
        String Y = "XYZ";
        List<Integer> result = anagramSubstring(X, Y);
        System.out.println(result);
    }

    private static List<Integer> anagramSubstring(String x, String y) {
        int left = 0;
        int right = y.length() - 1;
        List<Integer> result = new ArrayList<>();

        //Find frequency of all characters of the string which is to be searched
        Map<Character, Long> first = y.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        while (right < x.length()) {
            String candidate = x.substring(left, right + 1);

            //check if the candidate substring is possible anagram
            Map<Character, Long> second = candidate.chars().mapToObj(ch -> (char) ch)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            boolean match = first.entrySet()
                    .stream()
                    .allMatch(key -> second.get(key.getKey()) != null && second.get(key.getKey()).equals(key.getValue()));

            if (match)
                result.add(left);

            left++;
            right++;
        }
        return result;
    }
}
