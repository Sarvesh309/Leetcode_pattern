package Two_Pointers;

//Given two sorted arrays A and B, and another value k, print the kth element of the resultant sorted array.
//
//Example
//A: [1, 2, 3, 4, 5, 6]
//B: [3, 4, 4, 5, 6, 6]
//Result: [1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6]
//3rd element in the array is 3.
//6th element in the array is 4.
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
        //At this stage, any one of the pointer left or right will point to the end index of array,
        // hence we can execute below while loops in any order either left or right first
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
