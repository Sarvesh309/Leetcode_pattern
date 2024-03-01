package Sliding_window.SubArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] nums = {2, 6, 0, 9, 7, 3, 1, 4, 1, 10};
        int target = 15;
        List<Integer> result = subArraySum(nums, target);

        //Boxing means primitive to object in layman terms
        List<Integer> inputList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> finalresult = inputList.subList(result.get(0), result.get(1) + 1);
        System.out.println(finalresult);
    }

    private static List<Integer> subArraySum(int[] nums, int target) {

        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        int curr_sum = 0;
        while (right < nums.length) {
            curr_sum += nums[right];

            while (curr_sum > target && left < right) {
                curr_sum -= nums[left];
                left++;
            }
            if (curr_sum == target) {
                result.add(left);
                result.add(right);
                break;
            }
            right++;
        }
        return result;
    }
}
