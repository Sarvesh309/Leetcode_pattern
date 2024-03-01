package RecursionAndBacktracking;

import java.util.Arrays;

public class KnightTour {
    public static void main(String[] args) {
        int[][] chess = new int[5][5];
//        for (int i = 5; i >= 0; i--) {
//            for (int j = 5; j >= 0; j--) {
                knightTour(chess, 2, 3, 1);
//            }
//        }
    }

    private static void knightTour(int[][] chess, int row, int column, int move) {
        if (row < 0 || column < 0 || row >= chess.length || column >= chess.length || chess[row][column] > 0) {
            return;
        }
        if (move == chess.length * chess.length) {
            chess[row][column] = move;
            displayChessBoard(chess);
            chess[row][column]=0;

            return;
        }

        chess[row][column] = move;
        knightTour(chess, row - 2, column + 1, move + 1);
        knightTour(chess, row - 1, column + 2, move + 1);
        knightTour(chess, row + 1, column + 2, move + 1);
        knightTour(chess, row + 2, column + 1, move + 1);
        knightTour(chess, row + 2, column - 1, move + 1);
        knightTour(chess, row + 1, column - 2, move + 1);
        knightTour(chess, row - 1, column - 2, move + 1);
        knightTour(chess, row - 2, column - 1, move + 1);

        chess[row][column] = 0;
    }

    private static void displayChessBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
                System.out.println(Arrays.toString(chess[i]) + "\t");
        }
    }
}
