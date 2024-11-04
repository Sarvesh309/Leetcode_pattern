package Two_Pointers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class moveZeroesToRight {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 0, 4, 6, 0, 9, 0, 8};
        moveZeroes(arr);
        List<Integer> result = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(result);
    }

    private static void moveZeroes(int[] arr) {
        int leftMostZeroPointr = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                if(i==leftMostZeroPointr) {
                    leftMostZeroPointr++;
                    continue;
                }
                swap(arr,i,leftMostZeroPointr);
                leftMostZeroPointr++;               //This is very important step to ensure correct placing of leftMostZeroPointr
                                            // i.e:- on first occurence of 0 after the previously swapped non-zeroth position
            }
        }

    }

    private static void swap(int[] arr, int i, int zeroPointr) {
        int temp = arr[zeroPointr];
        arr[zeroPointr] = arr[i];
        arr[i] = temp;
    }
}
