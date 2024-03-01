package Two_Pointers;

import java.util.Arrays;

//Sort zeros, Ones and two's in O(n) using three pointers

public class DutchNationalFlag_ThreePointerAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 0, 1};
        three_pointer(arr);
        System.out.println(Arrays.toString(arr));
    }

    //2, 2, 0, 1
    //0, 1, 2, 2
    private static void three_pointer(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
//                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        arr[first] = arr[first] + arr[second];
        arr[second] = arr[first] - arr[second];
        arr[first] = arr[first] - arr[second];
    }
}
