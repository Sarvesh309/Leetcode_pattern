package DynamicProgramming.RecursiveSolutions;

//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//Example 1:
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps

public class ClimbingStairsRecursion {
    public static void main(String[] args) {
        int n = 10;
        System.out.println((recursion(n)));
    }

    static int recursion(int n) {
        if (n < 0)
            return 0;

        //base condition ie:- top stair reached
        if (n == 0)
            return 1;

        int one_stair_value = recursion(n - 1);
        int two_stair_value = recursion(n - 2);

        return one_stair_value + two_stair_value;
    }
}
