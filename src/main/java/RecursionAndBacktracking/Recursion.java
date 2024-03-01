package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> answer = recursion(arr, 0,r, r, result);
        for (List<Integer> combination : answer) {
            System.out.println(combination);
            System.out.println("\n");
        }
    }

    private static List<List<Integer>> recursion(int[] arr, int index, int length, int fixed_length, List<List<Integer>> result) {

        //base condition
        if(length<=0){
            List<List<Integer>> combinations = new ArrayList<>();
            for (int i = index; i < arr.length; i++) {
                ArrayList<Integer> combination = new ArrayList<>(1);
                combination.add(arr[i]);
                combinations.add(combination);
            }
            return combinations;
        }

        int first = arr[index];
        List<List<Integer>> combinations = recursion(arr, index + 1, length-1,fixed_length, result);
        ArrayList<List<Integer>> combinationlist = new ArrayList<>(combinations);
        for (List<Integer> combination : combinations) {
            if(combination.size()<fixed_length) {
                ArrayList<Integer> newCombination = new ArrayList<>(combination);
                newCombination.add(0, first);
                combinationlist.add(newCombination);
            }
            if(combination.size()==fixed_length)
                result.add(combination);
        }
        return combinationlist;
    }
}
