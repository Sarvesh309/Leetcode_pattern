package Binary_Search;

import java.util.Arrays;
import java.util.List;

//You are given a list of unique integers which are sorted but rotated at some pivot.
// You are also given a target value and you have to find its index in the list. If it is not present in the list, return -1.
//
//Example:
//List: [4, 5, 6, 7, 1, 2, 3]
//Target value: 6
//Resultant index: 2
public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 6, 7, 8, 9, 10, 1, 2, 3);
        int target_value = 1;
        int size = list.size();
        int pivot = find_pivot(list, 0, size - 1); // Pivot point is the index where the array is rotated,
                                                                // ie:- it is the largest element
        int result = -1;
        if (target_value > list.get(0)) {
            result = binary_search(list, 0, pivot, target_value);
        } else if (target_value < list.get(size - 1)) {
            result = binary_search(list, pivot, size - 1, target_value);
        }
        System.out.println(result);
    }

    private static int binary_search(List<Integer> list, int left, int right, int target_value) {
        while (left < right) {
            int mid = (left + right) / 2;
            Integer midValue = list.get(mid);
            if (target_value == midValue) {
                return mid;
            }
            if (target_value > midValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //4,5,6,7,8,9,10,1,2,3
    private static Integer find_pivot(List<Integer> list, int left, int right) {
        if (left > right) {
            return -1;
        }
//        if (left == right)
//            return left;
        int mid = (left + right) / 2;
        int mid_value = list.get(mid);

        if (mid_value < list.get(mid - 1)) {
            return (mid - 1);
        } else if (mid_value > list.get(mid + 1)) {
            return mid;
        } else if (list.get(left) >= list.get(mid)) {
            return find_pivot(list, left, mid - 1);
        } else
            return find_pivot(list, mid + 1, right);
    }
}
