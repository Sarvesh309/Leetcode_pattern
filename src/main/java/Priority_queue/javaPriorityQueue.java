package Priority_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class javaPriorityQueue {
    public static void main(String[] args) {
        int arr[] = new int[]{7, 4, 6, 3, 9, 1};
        int k = 2;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));


        Integer polled = null;
        for (int i = 0; i < k; i++) {
            polled = queue.poll();
        }
        System.out.println(polled + "\t");
    }
}
