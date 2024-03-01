package Two_Pointers;

import java.util.*;

public class TripletSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, -2, -1, 1, 2};
        int sum = 0;
        Set<List<Integer>> resultSet = threeSum(nums, sum);
        List<List<Integer>> resultList = new ArrayList<>(resultSet);
        System.out.println(resultList);
    }

    //-4, -1, -1, 0, 1, 2
    private static Set<List<Integer>> threeSum(int[] nums, int sum) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if ((sum - temp) == nums[left] + nums[right]) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if ((sum - temp) > nums[left] + nums[right]) {
                    left++;
                } else if ((sum - temp) < nums[left] + nums[right]) {
                    right--;
                }
            }
        }
        return result;
    }
}
