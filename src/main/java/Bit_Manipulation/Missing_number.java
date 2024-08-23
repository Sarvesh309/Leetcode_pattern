package Bit_Manipulation;

//Given an array nums containing n distinct numbers in the range [0, n],
// return the only number in the range that is missing from the array.

//Input: nums = [3,0,1]
//Output: 2

//Input: nums = [9,6,4,2,3,5,7,0,1]
//Output: 8
public class Missing_number {
    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        //Sum of 1st n numbers starting from 1 is n(n+1)/2

        int missing_number = (nums.length + 1) * (nums.length) / 2 - sum;
        System.out.println(missing_number);
    }
}