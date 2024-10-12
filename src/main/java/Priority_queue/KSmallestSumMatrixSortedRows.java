package Priority_queue;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KSmallestSumMatrixSortedRows {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 10, 10};
        int[] nums2 = new int[]{1, 4, 5};
        int[] nums3 = new int[]{2, 3, 6};
        int k = 7;

        kthSmallestSum(nums1, nums2, nums3, k);
    }

    private static void kthSmallestSum(int[] nums1, int[] nums2, int[] nums3, int k) {
        PriorityQueue<Map<Integer, List<Integer>>> queue = new PriorityQueue<>();
        

    }
}
