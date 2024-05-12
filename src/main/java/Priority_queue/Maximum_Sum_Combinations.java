package Priority_queue;

import java.util.Collections;
import java.util.PriorityQueue;

//Given two equally sized 1-D arrays A, B containing N integers each.
//
//A sum combination is made by adding one element from array A and another element of array B.
//
//Return the maximum C valid sum combinations from all the possible sum combinations.
public class Maximum_Sum_Combinations {
    public static void main(String[] args) {
        int[] A = new int[]{3, 2};
        int[] B = new int[]{1, 4};
        int c = 2;

        PriorityQueue<Integer> sum = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int temp_sum = A[i] + B[j];
                sum.add(temp_sum);
            }
        }
        while (c > 0) {
            System.out.println(sum.poll());
            c--;
        }
    }

}
