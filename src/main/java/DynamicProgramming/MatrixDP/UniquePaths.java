package DynamicProgramming.MatrixDP;

//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
// The robot can only move either down or right at any point in time.

//Given the two integers m and n,
// return the number of possible unique paths that the robot can take to reach the bottom-right corner.

//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down

public class UniquePaths {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        int istart_index = 0;
        int jstart_index = 0;

        System.out.println((dpSolution(m, n)));
        System.out.println(recursion(m, n, istart_index, jstart_index));
    }

    static int dpSolution(int n, int m) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;            // Total Paths to [0,0] index is 1
                }
                else {
                    int left = 0, right = 0;
                    if (i > 0)
                        left = dp[i - 1][j];
                    if (j > 0)
                        right = dp[i][j - 1];

                    dp[i][j] = left + right;    // fill on the next blocks using only single base block [0][0]
                }
            }
        }
        return dp[m-1][n-1];
    }

    static int recursion(int m, int n, int i, int j) {
        if (i == m - 1 || j == n - 1)
            return 1;

        return recursion(m, n, i + 1, j) + recursion(m, n, i, j + 1);
    }
}
