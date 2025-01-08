package DynamicProgramming.MatrixDP;

import java.util.Arrays;


public class Goldmine {
    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        int[][] dp = new int[mat.length + 1][mat.length + 1];
        for (int i = 0; i < mat.length; i++) {
            dp[i][0] = mat[i][0];
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 1; j < mat.length; j++) {
                 if (i == 0) {
                    dp[i][j] = mat[i][j] + Math.max(dp[i][j - 1], dp[i + 1][j - 1]);
                } else if (i == mat.length - 1) {
                    dp[i][j] = mat[i][j] + Math.max(dp[i][j - 1], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = mat[i][j] + (Arrays.asList(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]).stream().max(Integer::compare).get());
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Integer.max(max, dp[i][mat.length - 1]);
        }
        System.out.println(max);
    }
}
