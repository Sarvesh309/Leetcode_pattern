package Two_Pointers;

public class KthElementOf2sortedlists {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 6, 7, 9};
        int[] arr2 = new int[]{1, 4, 8, 10};
        int k = 5;
        int result = findKthElement(arr1, arr2, k);
        System.out.println(result);
    }

    // 2, 3, 6, 7, 9
    // 1, 4, 8, 10
    private static int findKthElement(int[] arr1, int[] arr2, int k) {
        int left = 0;
        int right = 0;
        int counter = 0;
        while (left < arr1.length && right < arr2.length) {
            if (arr1[left] <= arr2[right]) {
                counter++;
                if (counter == k) {
                    return arr1[left];
                }
                left++;
            } else if (arr1[left] > arr2[right]) {
                counter++;
                if (counter == k)
                    return arr2[right];
                right++;
            }
        }
        while (left < arr1.length) {
            counter++;
            if (counter == k)
                return arr1[left];
            left++;
        }
        while (right < arr2.length) {
            counter++;
            if (counter == k)
                return arr2[right];
            right++;
        }
        return -1;
    }
}
