package String;

import java.util.*;

// Time complexity reduced from o(N3) to o(N2)

public class countpalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abaa";
        int map = largestpalindromeLength(str);
        // map of palindrome length to its coordinates
        System.out.println(map);
    }

    private static int largestpalindromeLength(String str) {

        int[][] dp = new int[str.length()][str.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }

        Map<Integer, int[]> result = new TreeMap<>(Comparator.reverseOrder());
        int longestLength = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j <= str.length() - 1; j++) {
                if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] > 0) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == -1) {
                    dp[i][j] = 2;
                } else if (str.charAt(i) != str.charAt(j)) {
                    dp[i][j] = 0;
                }
                if (longestLength < dp[i][j]) {
                    longestLength = dp[i][j];
                    result.put(longestLength, new int[]{i, j});
                }
            }
        }
        return (int) Arrays.stream(dp).flatMapToInt(Arrays::stream).filter(i -> i >= 2).count();
    }
}
