package DynamicProgramming.recursion;

//You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.
//Find the number of ways of selecting the elements from the array such that the sum of chosen elements
// is equal to the target 'k'.
//You can select single element only once in an individual subset

//TODO:- 0/1 knapsack
public class CountOfSubsetsWithSumKResursion {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 4, 5};
        int sum = 5;
        int index = 0;
        System.out.println(countOffsetSumTillNode(arr, sum, index));
    }

    static int countOffsetSumTillNode(int[] num, int tar, int index) {
        if (tar == 0)
            return 1;
        if (tar < 0 || index >= num.length)
            return 0;
        if (num[index] > tar)
            return countOffsetSumTillNode(num, tar, index + 1);
        else
            return countOffsetSumTillNode(num, tar - num[index], index + 1) + countOffsetSumTillNode(num, tar, index + 1);
    }
}
