package RecursionAndBacktracking.recursion;

public class PrintPermutations {

    public static void main(String[] args) {
        String input = "abc";
        printPermutations(input, "");
    }

    private static void printPermutations(String input, String output) {

        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char first = input.charAt(i);
            String newInput = input.replace(String.valueOf(first), "");
            printPermutations(newInput, output + first);
        }
    }
}
