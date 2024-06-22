package DynamicProgramming;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String str = "geeks";
        boolean[][] dp = new boolean[str.length()][str.length()];
        System.out.println(Dp(str, dp));
    }

    // g e e k s
//g
//e
//e
//k
//s
    private static String Dp(String str, boolean[][] dp) {
        int longest_so_far = 0, start_index = 0;

        for (int i = 0; i < str.length(); i++) {
            longest_so_far = 1;
            start_index = i;
            dp[i][i] = true;
        }
        // Note here the end is fixed, start varies for each candidate substring
        for (int end = 0; end < dp.length; end++) {
            for (int start = 0; start < end; start++) {
                if (str.charAt(start) == str.charAt(end) && (dp[start + 1][end - 1] || (end - start)<=1)) {
                    dp[start][end] = true;
                    if (end - start + 1 > longest_so_far) {
                        longest_so_far = end - start + 1;
                        start_index = start;
                    }
                }
            }
        }
        return str.substring(start_index, longest_so_far + start_index);
    }
}
