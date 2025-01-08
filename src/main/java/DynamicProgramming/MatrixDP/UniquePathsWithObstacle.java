package DynamicProgramming.MatrixDP;

//Check discription of Unique Paths and add obstacles in between xD

//Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//Output: 2
//Explanation: There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right

public class UniquePathsWithObstacle {

    static int[][] obstacleGrid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

    public static void main(String[] args) {
        System.out.println(dpSolution(obstacleGrid));
    }

    static int dpSolution(int[][] obstacleGrid) {

        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] dp = new int[r][c];

        if (obstacleGrid[r - 1][c - 1] == 1 || obstacleGrid[0][0] == 1)  ///optimized case
            return 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 && j == 0)                // starting block
                    dp[i][j] = 1;

                else if (obstacleGrid[i][j] == 1)    // if obstacle present in path add 0 against it in dp Array
                    dp[i][j] = 0;

                else {
                    int top, left;
                    top = left = 0;
                    if (i > 0)
                        top = dp[i - 1][j];
                    if (j > 0)
                        left = dp[i][j - 1];

                    dp[i][j] = top + left;
                }
            }
        }
        return dp[r - 1][c - 1];
    }
}
