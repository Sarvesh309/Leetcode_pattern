package String;

import java.util.Arrays;

//Given a very large integer n in the form of string, the task is to return the largest palindromic number obtainable by permuting the digits of n.
// If it is not possible to make a palindromic number, then return an empty string.

//Input : "313551"
//Output : "531135"
//Explanations : 531135 is the largest number which is a palindrome.
// 135531, 315513 and other numbers can also be formed but we need the largest of all of the palindromes.

public class LargestPalindromeByPermutingDigits {
    public static void main(String[] args) {
        String s = "313551";
        String res = largestPalindrome(s);
        System.out.println(res);
    }

    private static String largestPalindrome(String s) {

        int[] freq = new int[10];
        for (char ch : s.toCharArray()) {
            freq[ch - '0']++;
        }
        long count = Arrays.stream(freq).filter(ch -> ch % 2 == 1).count();
        if (count > 1) return "";

        int[] result = new int[s.length()];
        for (int k = 0; k < freq.length; k++) {
            if ((freq[k] & 1) == 1) {
                result[result.length / 2] = k;        // put the odd frequency character at middle & reduce the frequency by 1
                freq[k]--;
                break;
            }
        }
        int front = 0;
        for (int i = 9; i >= 0; i--) {
            while (freq[i] != 0) {
                freq[i] -= 2;
                result[front] = result[result.length - 1 - front] = i;    // put the remaining characters starting from 9 to 0 at front & end & reduce frequency by 2
                front++;
            }
        }
        return Arrays.stream(result).mapToObj(String::valueOf).reduce((a, b) -> a + b).get();
    }
}