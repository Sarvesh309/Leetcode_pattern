package Heaps;

import java.util.*;
import java.util.stream.Collectors;

public class SortKSortedArrays {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        int k = 2;
        System.out.println(sortKSortedArrays(arr, k));
    }

    private static List<Integer> sortKSortedArrays(int[] arr, int k) {
        int left = 0;
        int right = left + k;
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        LinkedList<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toCollection(LinkedList::new));

        while (right < arr.length) {
            pqueue.addAll(list.subList(left, right + 1));
            for (int i = left; i <= left + k; i++) {
                if(i<list.size()) {
                    list.remove(i);
                }
            }
            while (!pqueue.isEmpty()) {
                list.push(pqueue.poll());
            }
            left++;
            right++;
        }
        return result;
    }
}
