package Sliding_window.SubArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinSumSubarayWithKDistinctChar {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 4, 2, 5, 6, 3, 8, 1};
        int k = 8;
        if (k > arr.length) {
            System.out.println(Arrays.stream(arr).mapToObj(ch -> ch).collect(Collectors.toList()));
            return;
        }
        int[] ints = minSumSubarray(arr, k);

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> result = list.subList(ints[0], ints[1] + 1);
        System.out.println(result);
//        Stream.of(ints).flatMapToInt(Arrays::stream).forEach(System.out::println);
    }

    private static int[] minSumSubarray(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int[] result = new int[2];
        int minSum = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();
        while (right < arr.length) {
            int curr = arr[right];
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }
                left++;
            }
            if (map.size() == k) {
                Integer temp = map.entrySet().stream().map(key -> key.getKey() * key.getValue()).reduce(Integer::sum).get();
                if (temp < minSum) {
                    minSum = temp;
                    result[0] = left;
                    result[1] = right;
                }
            }
            right++;
        }
        return result;
    }
}
