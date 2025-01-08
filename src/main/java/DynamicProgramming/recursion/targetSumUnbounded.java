package DynamicProgramming.recursion;

import java.util.*;
import java.util.stream.Collectors;

//Given an array of distinct integers candidates and a target integer target,
// return a list of all unique combinations of candidates where the chosen numbers sum to target.
// The same number may be chosen from candidates an unlimited number of times.

// Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7


//TODO:- UNBOUNDED KNAPSACK
public class targetSumUnbounded {
    static Set<List<Integer>> result = new HashSet<>();

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        int sum_till_prev_node = 0;
        String combination = "";
        int curr_index = 0;
        recursion(candidates, target, sum_till_prev_node, combination, curr_index);
        return new ArrayList<>(result);
    }

    static void recursion(int[] candidates, int target, int sum_till_prev_node, String combination, int curr_index) {
        if (sum_till_prev_node == target) {
            List<Integer> path = Arrays.stream(combination.split(" ")).
                    map(Integer::parseInt).
                    collect(Collectors.toList());

            result.add(path);
            return;
        }
        if (curr_index > candidates.length - 1)
            return;

        if (sum_till_prev_node > target)
            return;

        int newSum = sum_till_prev_node + candidates[curr_index];

        String newCombination = combination == "" ? String.valueOf(candidates[curr_index]) : combination + " " + String.valueOf(candidates[curr_index]);

        recursion(candidates, target, newSum, newCombination, curr_index);
        recursion(candidates, target, newSum, newCombination, curr_index + 1);
        recursion(candidates, target, sum_till_prev_node, combination, curr_index + 1);
    }
}
