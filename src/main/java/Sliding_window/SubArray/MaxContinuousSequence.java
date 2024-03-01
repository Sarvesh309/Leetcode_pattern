package Sliding_window.SubArray;

public class MaxContinuousSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};
        int k = 1;
        int result = maxContinuousSequence(nums, k);
        System.out.println(result);
    }

    /*
     Function to calculate maximum sequence of continuous 1’s with k distinct zeroes
     */
    private static int maxContinuousSequence(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int result = 0;

        int zero = 0;
        while (right < nums.length) {
            int curr = nums[right];
            if (curr == 0) {
                zero++;
            }
            while (zero > k) {
                if (nums[left] == 0)
                    zero--;
                left++;
            }
            if (zero==k) {
                if (result < right - left + 1) {
                    result = right - left + 1;
                }
            }
            right++;
        }
        return result;
    }
}
