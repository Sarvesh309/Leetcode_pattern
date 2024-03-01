package Two_Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Merge_Two_sorted_list {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 4, 10};
        int[] arr2 = new int[]{2, 4, 6, 7, 8, 9};
        List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        System.out.println(merge(list1, list2));
    }

    //1, 2, 3, 4, 4, 5, 6, 7, 8, 9, 10
    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        while (left < list1.size() && right < list2.size()) {
            if (list1.get(left) <= list2.get(right)) {
                result.add(list1.get(left));
                left++;
            } else if (list1.get(left) > list2.get((right))) {
                result.add(list2.get(right));
                right++;
            }
        }
        if (left == list1.size()) {
            result.addAll(list2.subList(right, list2.size()));
        } else if (right == list2.size()) {
            result.addAll(list1.subList(left, list1.size()));
        }
        return result;
    }
}
