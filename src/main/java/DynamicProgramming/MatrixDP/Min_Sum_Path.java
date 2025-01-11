package DynamicProgramming.MatrixDP;


//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
// which minimizes the sum of all numbers along its path.
//
//Note: You can only move either down or right at any point in time

//Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//Output: 7
//Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.


public class Min_Sum_Path {
    public static void main(String[] args) {

        int[][] grid = new int[][]{{1, 2, 3,}, {4, 5, 6}};
        int m = grid.length;
        int n = grid[0].length;
        System.out.println((minPath(grid, m - 1, n - 1)));
        System.out.println((dpSolution(m, n, grid)));
    }

    public static int minSumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
//        return minPath(grid,m-1,n-1);

        return dpSolution(m, n, grid);
    }


    static int dpSolution(int m, int n, int[][] grid) {

//        Bottom up Tabulation

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                    continue;
                } else {
                    int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
                    if (i > 0) {
                        top = dp[i - 1][j];
                    }
                    if (j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = Math.min(left, top) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    static int minPath(int[][] grid, int i, int j) {
        if (i == 0 && j == 0)
            return grid[0][0];

        else if (i < 0 || j < 0)
            return Integer.MAX_VALUE;

        return Math.min(minPath(grid, i - 1, j), minPath(grid, i, j - 1)) + grid[i][j];
    }
}
