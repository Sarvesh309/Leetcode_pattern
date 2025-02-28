package DynamicProgramming.DpLIS;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 10, 4, 3, 8, 9};
        int length = arr.length;

//        LISHelper(-1, 0, arr);
//        System.out.println(LIS_Till_Node(arr, length - 1, -1));
        int[][] dp = new int[length][length];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        System.out.println(memoizedDpSolution(arr, dp, length - 1, -1));
    }

    static int memoizedDpSolution(int[] arr, int[][] dp, int curr, int next) {
        if (curr < 0)
            return 0;

        //Include condition
        int includeCurrent = Integer.MIN_VALUE;
        if (next == -1 || arr[curr] < arr[next]) {
            if (curr - 1 >= 0 && dp[curr - 1][curr] != Integer.MIN_VALUE)
                includeCurrent = 1 + dp[curr - 1][curr];
            else {
                includeCurrent = 1 + memoizedDpSolution(arr, dp, curr - 1, curr);
            }
        }

        //Exclude condition
        int excludeCurrent;
        if ((curr - 1 > 0 && next > 0) && dp[curr - 1][next] != Integer.MIN_VALUE)
            excludeCurrent = dp[curr - 1][next];
        else {
            excludeCurrent = memoizedDpSolution(arr, dp, curr - 1, next);
        }

        int nodeValue = Math.max(includeCurrent, excludeCurrent);
        if (curr > 0 && next > 0) {
            dp[curr][next] = nodeValue;
        }

        return nodeValue;
    }
}


