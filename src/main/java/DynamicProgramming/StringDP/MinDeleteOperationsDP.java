package DynamicProgramming.StringDP;

//Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
//
//In one step, you can delete exactly one character in either string.
//Input: word1 = "sea", word2 = "eat"
//Output: 2
//Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea"

//TODO:- LCS
public class MinDeleteOperationsDP {
    public static void main(String[] args) {
        String word1 = "leetcode", word2 = "etco";
        int lcs = dpSolution(word1, word2);
        System.out.println(word1.length() + word2.length() - (2 * lcs));
    }

    static int dpSolution(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
