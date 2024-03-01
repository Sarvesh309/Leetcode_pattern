package Sliding_window.SubArray;

public class MinSizeSubarraySum {

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int end=0;

        int length = nums.length;
        int temp=nums[start];
        int result=Integer.MAX_VALUE;

        while(end<length){
            if(temp==target){
                int candidate = end-start+1;
                result = Math.min(result,candidate);
                end++;
                if (end<length) {
                    temp=temp+nums[end];
                }
            }
            else if(temp>target){
                temp=temp-nums[start];
                start = start+1;
            }
            else if(temp<target){
                end++;
                if(end<length){
                    temp+=nums[end];
                }
            }
        }
        return result;
    }
}
