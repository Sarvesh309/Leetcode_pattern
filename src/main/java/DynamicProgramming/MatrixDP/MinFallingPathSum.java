package DynamicProgramming.MatrixDP;

import java.util.Arrays;

//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.

//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown

public class MinFallingPathSum {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int size = matrix.length;
        int result = Integer.MAX_VALUE;

        int[][] dp = new int[size][size];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int j = 0; j < size; j++) {
            result = Math.min(result, topDownDpSolution(matrix, 0, j, size - 1, dp));
        }
        System.out.println(result);
    }


    static int topDownDpSolution(int[][] matrix, int i, int j, int endRow, int[][] dp) {

        // invalid input / index out of grid cases
        if (i < 0 || j < 0 || i > endRow || j > endRow)
            return Integer.MAX_VALUE;

        // base case
        if (i == endRow) {
            return matrix[i][j];
        }

        //TOP - DOWN Memoization
        int diagonalLeft, diagonalRight, down;
        diagonalLeft = (isValid(i + 1, j - 1, endRow) && dp[i + 1][j - 1] != Integer.MAX_VALUE) ? dp[i + 1][j - 1] : topDownDpSolution(matrix, i + 1, j - 1, endRow, dp);
        diagonalRight = (isValid(i + 1, j + 1, endRow) && dp[i + 1][j + 1] != Integer.MAX_VALUE) ? dp[i + 1][j + 1] : topDownDpSolution(matrix, i + 1, j + 1, endRow, dp);
        down = (isValid(i + 1, j, endRow) && dp[i + 1][j] != Integer.MAX_VALUE) ? dp[i + 1][j] : topDownDpSolution(matrix, i + 1, j, endRow, dp);

        int nodeValue = Math.min(down, Math.min(diagonalLeft, diagonalRight)) + matrix[i][j];
        dp[i][j] = nodeValue;
        return nodeValue;
    }

    static boolean isValid(int i, int j, int endRow) {
        if (i < 0 || j < 0 || i > endRow || j > endRow) {
            return false;
        }
        return true;
    }

}
