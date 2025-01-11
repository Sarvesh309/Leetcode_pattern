package DynamicProgramming.recursion;

//Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below
// or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col),
// or (row + 1, col + 1).

//Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//Output: 13
//Explanation: There are two falling paths with a minimum sum as shown.

//Input: matrix = [[-19,57],[-40,-5]]
//Output: -59
//Explanation: The falling path with a minimum sum is shown


public class MinFallingPathSumRecursion {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        int size = matrix.length;
        int result = Integer.MAX_VALUE;

        for (int j = 0; j < size; j++) {
            result = Math.min(result, minFallingPathSumTillNode(matrix, 0, j, size - 1));
        }
        System.out.println(result);
    }


    static int minFallingPathSumTillNode(int[][] matrix, int i, int j, int endRow) {
        if (i < 0 || j < 0 || i > endRow || j > endRow)
            return Integer.MAX_VALUE;

        if (i == endRow) {
            return matrix[i][j];
        }
        int diagLeft = minFallingPathSumTillNode(matrix, i + 1, j - 1, endRow);
        int diagRight = minFallingPathSumTillNode(matrix, i + 1, j + 1, endRow);
        int down = minFallingPathSumTillNode(matrix, i + 1, j, endRow);

        return Math.min(down, Math.min(diagLeft, diagRight)) + matrix[i][j];
    }
}
