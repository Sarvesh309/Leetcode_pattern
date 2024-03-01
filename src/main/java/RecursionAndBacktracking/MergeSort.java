package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{38, 27, 43, 10};
        int[] ints = mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(ints).forEach(System.out::println);
    }

    private static int[] mergeSort(int[] arr, int start, int end) {

        if (end - start == 1) {
            if (arr[start] > arr[end]) {
                return new int[]{arr[end], arr[start]};
            }
        }

        int mid = (start + end) / 2;
        int[] branch1 = mergeSort(arr, start, mid);
        int[] branch2 = mergeSort(arr, mid + 1, end);

        return merge(branch1, branch2);
    }

    private static int[] merge(int[] branch1, int[] branch2) {
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < branch1.length && j < branch2.length) {
            if (branch1[i] <= branch2[j]) {
                result.add(branch1[i]);
                i++;
            } else if (branch1[i] > branch2[j]) {
                result.add(branch2[j]);
                j++;
            }
            if (i == branch1.length) {
                result.addAll(Arrays.stream(branch2).boxed().collect(Collectors.toList()).subList(j, branch2.length));
            }
            if (j == branch2.length) {
                result.addAll(Arrays.stream(branch1).boxed().collect(Collectors.toList()).subList(i, branch1.length));
            }
        }
        return result.stream().mapToInt(num -> num).toArray();
    }
}

