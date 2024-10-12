package DynamicProgramming.recursion;

//Given an array of integers and target value, print all subsets which make the target value
//You can choose one element only once in an individual subset
//For ex:- arr {10,20,30,40,50} , target = 70
//Output-
//[10,20,40]
//[20,50]
//[30,40]

//TODO:- 0/1 knapsack
public class CombinationSumBounded {
    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50};
        int target = 70;

        targetSumRecursion(arr, target, 0, 0, "");
    }

    private static void targetSumRecursion(int[] arr, int target, int index, int sum_till_node, String subset) {

        if (index > arr.length) {
            return;
        }
        if (index == arr.length) {
            if (target == sum_till_node) {
                System.out.println(subset);
            }
            return;
        }

        targetSumRecursion(arr, target, index + 1, sum_till_node + arr[index], subset + " " + (arr[index]));
        targetSumRecursion(arr, target, index + 1, sum_till_node, subset);
    }
}
