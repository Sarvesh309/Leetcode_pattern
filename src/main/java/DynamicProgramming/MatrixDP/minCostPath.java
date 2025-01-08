package DynamicProgramming.MatrixDP;

public class minCostPath {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {9, 4, 9, 9},
                {6, 7, 6, 4},
                {8, 3, 3, 7},
                {7, 4, 9, 10}
        };

        //TABULAR APPROACH
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        dp[arr.length - 1][arr.length - 1] = arr[arr.length - 1][arr.length - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (i == arr.length-1 && j == arr.length-1) {
                    continue;
                }
                else if (i == arr.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i][j+1];
                }
                else if (j == arr.length - 1) {
                    dp[i][j] = arr[i][j] + dp[i+1][j];
                }
                else {
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
