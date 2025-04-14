package Binary_Search;

import java.util.Arrays;

public class findIndexUsingBinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,12,32,44,53,76,54,321,555,232};
        int b = 53;
        Arrays.sort(arr);
        int result = binarySearch(arr, 0, arr.length - 1, b);
        System.out.println(result);
    }

    private static int binarySearch(int[] arr, int left, int right, int numToSearch) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == numToSearch) {
                return mid;
            } else if (numToSearch > arr[mid]) {
                left = mid + 1;
            } else if (numToSearch < arr[mid]) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
