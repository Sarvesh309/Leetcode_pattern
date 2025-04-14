package String;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String str = "geeks";
        boolean[][] dp = new boolean[str.length()][str.length()];
        System.out.println(Dp(str, dp));
    }

            // end
            // g e e k s
//s     //g
//t     //e
//a     //e
//r     //k
//t     //s

    private static String Dp(String str, boolean[][] dp) {
        int longest_so_far = 1, start_index = 0;

        for (int i = 0; i < str.length(); i++) {
            start_index = i;
            dp[i][i] = true;
        }
        // Note here the end is outer for loop & start inner forloop ie. This way the smaller substrings are appropriately traversed
        // in order to depict palindromicity for larger substrings
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
