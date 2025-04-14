package RecursionAndBacktracking.backtracking;

import java.util.ArrayList;
import java.util.List;

//Print permutation using swap method Backtracking with no/minimal pruning
public class PrintPermutationsUsingBacktracking {
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String input = "abc";

        permute(input, 0, input.length() - 1);
        System.out.println(result);
    }

    private static void permute(String input, int start, int end) {
        if (start > end) {
            result.add(input);
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(input, start, i);
            permute(input, start + 1, end);
            swap(input, start, i);
        }
    }

    private static void swap(String input, int start, int i) {
        StringBuilder builder = new StringBuilder(input);
        char c = builder.charAt(start);
        builder.setCharAt(builder.charAt(start), builder.charAt(i));
        builder.setCharAt(builder.charAt(i), c);
    }
}