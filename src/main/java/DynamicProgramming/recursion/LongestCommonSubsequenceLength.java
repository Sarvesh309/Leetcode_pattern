package DynamicProgramming.recursion;

//Given two strings text1 and text2, return the length of their longest common subsequence.
// If there is no common subsequence, return 0.
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.

public class LongestCommonSubsequenceLength {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        int lcs = LCSTillStrings(text1, text2);
        System.out.println(lcs);

    }
    //recursive
    static int LCSTillStrings(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty())
            return 0;

        if (text1.charAt(text1.length() - 1) == text2.charAt(text2.length() - 1))
            return 1 + LCSTillStrings(text1.substring(0, text1.length() - 1), text2.substring(0, text2.length() - 1));

        else
            return Math.max(LCSTillStrings(text1.substring(0, text1.length() - 1), text2), LCSTillStrings(text1, text2.substring(0, text2.length() - 1)));
    }
}
