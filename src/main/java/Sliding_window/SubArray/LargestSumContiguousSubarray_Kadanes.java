package Sliding_window.SubArray;

//Given an array arr[] of size N. The task is to find the sum of the
// contiguous subarray within a arr[] with the largest sum.
//KADANE's algorithm. Also works for negative number
public class LargestSumContiguousSubarray_Kadanes {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int temp_res = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            temp_res = arr[i] + temp_res;
            result = Math.max(result, temp_res);

            //Fact 1:- A negative sum result will never add value to the max sum array
            //Fact 2:- A single negative element is also greater than addition of two consecutive negatives
            if (temp_res < 0) {
                temp_res = 0;
            }
        }
        System.out.println(result);
    }
}
