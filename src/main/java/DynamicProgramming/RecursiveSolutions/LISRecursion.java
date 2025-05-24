package DynamicProgramming.RecursiveSolutions;

public class LISRecursion {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 10, 4, 3, 8, 9};
        int length = arr.length;

//        LISHelper(-1, 0, arr);
        System.out.println(LIS_Till_Node(arr, length - 1, -1));
    }


    //Backward strategy
    private static int LIS_Till_Node(int[] arr, int curr, int next) {
        if (curr < 0)
            return 0;

        //Include condition
        int includeCurrent = 0;
        if (next == -1 || arr[curr] < arr[next]) {
            includeCurrent = 1 + LIS_Till_Node(arr, curr - 1, curr);
        }                                               // i/p     o/p

        //Exclude condition
        int excludeCurrent = LIS_Till_Node(arr, curr - 1, next);
                                                    // i/p     o/p
        return Math.max(includeCurrent, excludeCurrent);
    }

    //Forward strategy
    private static int LISHelper(int prev, int curr, int[] nums) {
        if (curr == nums.length)
            return 0;

        //Answer from 1st branch considering the element in subsequence
        // prev depicts answer till prev-Th index
        // curr depicts output remaining from index

        int op1 = 0;
        if (prev == -1 || nums[prev] < nums[curr]) {
            op1 = LISHelper(curr, curr + 1, nums) + 1 ;
        }                       // i/p     o/p

        //Answer from 2nd branch not considering the element in subsequence
        int op2 = LISHelper(prev, curr + 1, nums);
                            //i/p      o/p

        return Math.max(op1, op2);
    }
}
