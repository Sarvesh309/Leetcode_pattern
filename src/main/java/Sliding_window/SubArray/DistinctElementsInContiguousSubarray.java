package Sliding_window.SubArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctElementsInContiguousSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2, 3, 2, 1, 4, 5};
        int k = 1;
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println(distinctElements(list, k));
    }

    private static List<Integer> distinctElements(List<Integer> nums, int k) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = left + k;
        while (right <= nums.size()) {
            long count = nums.subList(left, right).stream().distinct().count();
            result.add((int) count);

            left++;
            right++;
        }
        return result;
    }
}
