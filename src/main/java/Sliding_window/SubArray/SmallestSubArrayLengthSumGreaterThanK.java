package Sliding_window.SubArray;

public class SmallestSubArrayLengthSumGreaterThanK {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 20;
        System.out.println(smallestSubArrayLength(nums, k));
    }

    private static int smallestSubArrayLength(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int result = 0;
        int temp = Integer.MAX_VALUE;

        //Iterate till the right pointer reaches end
        while (right < nums.length) {
            //add the values of right pointr
            result += nums[right];

            //slight change here in the 2nd step instead of usual update we will update the result inside the decrement loop
            while (result > k) {

                //update the length here
                if (right - left + 1 < temp) {
                    temp = right - left + 1;
                }
                result -= nums[left];
                left++;
            }
            right++;
        }
        return temp;
    }
}
