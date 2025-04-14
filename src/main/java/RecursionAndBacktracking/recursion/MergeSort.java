package RecursionAndBacktracking.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 1, 2, 3, 8,9,10, 11};
        int[] ints = seperateAndMerge(arr, 0, arr.length - 1);
        Arrays.stream(ints).forEach(System.out::println);
    }

    static int[] seperateAndMerge(int[] nums, int startIndex, int endIndex){
        //base cases

        if(startIndex == endIndex){
            return new int[]{nums[startIndex]};
        }
        if(endIndex-startIndex == 1){
            if(nums[startIndex]>=nums[endIndex])
                return new int[]{nums[endIndex], nums[startIndex]};
            else
                return new int[]{nums[startIndex], nums[endIndex]};
        }
        int mid = (startIndex + endIndex)/2;

        int[] list1 = seperateAndMerge(nums, startIndex, mid);
        int[] list2 = seperateAndMerge(nums, mid+1, endIndex);

        Integer[] ans = merge(list1, list2);

        return Arrays.stream(ans).mapToInt(Integer::intValue).toArray();
    }


    static Integer [] merge(int[] arr1, int[] arr2){
        int i,j;
        i=j=0;
        List<Integer> result = new ArrayList<>();
        while(i<=arr1.length-1 && j<=arr2.length-1){
            if(arr1[i] <= arr2[j]){
                result.add(arr1[i]);
                i++;
            }
            else if(arr2[j] < arr1[i]){
                result.add(arr2[j]);
                j++;
            }
        }
        if(i==arr1.length){
            List<Integer> sublist = Arrays.stream(arr2).mapToObj(num->(Integer)num).
                    collect(Collectors.toList()).subList(j, arr2.length);
            result.addAll(sublist);
        }

        if(j==arr2.length){
            List<Integer> sublist2 = Arrays.stream(arr1).mapToObj(num->(Integer)num).
                    collect(Collectors.toList()).subList(i, arr1.length);
            result.addAll(sublist2);
        }
        return result.toArray(new Integer[0]);
    }
}

