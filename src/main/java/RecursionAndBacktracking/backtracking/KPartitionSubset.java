package RecursionAndBacktracking.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given the Array of integers & integer K, check whether the elements can be partitioned into K subsets with equal Sum for every subset.
class KPartitionSubset {

    public static void main(String[] args) {

        int[] nums = new int[]{4,3,2,3,5,2,1};
        boolean isPossible = canPartitionKSubsets(nums, 4);
        System.out.println(isPossible);
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = Arrays.stream(nums).reduce(Integer::sum).getAsInt();

        if (sum % k == 1)
            return false;

        int target = sum / k;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(new ArrayList<>());
        }
        int[][] memo = new int [k][nums.length];
        for(int[] row : memo){
            Arrays.fill(row,-1);
        }

        return backtrack(target, result, 0, 0, nums, k);
    }


    static int memoisedBacktrack(int target, List<List<Integer>> result, int nonEmptySetCount, int currIndex, int[] nums, int k, int memo[][]){
        if(currIndex == nums.length){
            if(nonEmptySetCount == k){
                boolean isPartitionPossible = result.stream()
                        .map(list -> list.stream().mapToInt(Integer::intValue).sum())
                        .allMatch(sum->sum==target);
                return isPartitionPossible ? 1 : 0;
            }
            return 0;
        }

        for (int i = 0; i < k; i++) {
            List<Integer> subsetList = result.get(i);
            if (!subsetList.isEmpty()) {
                int element = nums[currIndex];
                subsetList.add(element);

                int isPossible;
                if(nonEmptySetCount < k && currIndex+1 < nums.length && memo[nonEmptySetCount][currIndex + 1]!=-1){
                    isPossible = memo[nonEmptySetCount][currIndex+1];
                }
                else{
                    isPossible = memoisedBacktrack(target, result, nonEmptySetCount, currIndex + 1, nums, k, memo);
                }
                if (isPossible==1) {
                    memo[nonEmptySetCount][currIndex]=1;
                    return 1;
                }
                subsetList.remove(subsetList.size() - 1);

            } else {
                int element = nums[currIndex];
                subsetList.add(element);

                int isPossible;
                if(nonEmptySetCount+1 < k && currIndex+1 < nums.length && memo[nonEmptySetCount+1][currIndex+1]!=-1){
                    isPossible = memo[nonEmptySetCount+1][currIndex+1];
                }
                else{
                    isPossible = memoisedBacktrack(target, result, nonEmptySetCount+1, currIndex + 1, nums, k, memo);
                }
                if (isPossible==1) {
                    memo[nonEmptySetCount][currIndex]=1;
                    return 1;
                }
                subsetList.remove(subsetList.size() - 1);
                break;
            }
        }

        if(nonEmptySetCount< k && currIndex < nums.length)
            memo[nonEmptySetCount][currIndex] = 0;

        return 0;
    }

    static boolean backtrack(int target, List<List<Integer>> result, int nonEmptySetCount, int currIndex, int[] nums, int k) {

        if (currIndex == nums.length) {
            if (nonEmptySetCount == k) {
                boolean isPartitionPossible = result.stream()
                        .map(list -> list.stream().mapToInt(Integer::intValue).sum())
                        .allMatch(sum -> sum == target);
                return isPartitionPossible;
            }
            return false;
        }

        for (int i = 0; i < k; i++) {
            List<Integer> subsetList = result.get(i);
            if (!subsetList.isEmpty()) {
                int element = nums[currIndex];
                subsetList.add(element);
                if (backtrack(target, result, nonEmptySetCount, currIndex + 1, nums, k))
                    return true;
                subsetList.remove(subsetList.size() - 1);
            } else {
                int element = nums[currIndex];
                subsetList.add(element);
                if (backtrack(target, result, nonEmptySetCount + 1, currIndex + 1, nums, k))
                    return true;
                subsetList.remove(subsetList.size() - 1);
                break;
            }
        }
        return false;
    }

}
