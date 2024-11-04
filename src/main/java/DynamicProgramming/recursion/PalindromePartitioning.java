package DynamicProgramming.recursion;

//Given a string s, partition s such that every
//substring of the partition is a palindrome
//Return the minimum cuts needed for a palindrome partitioning of s.
//Example:-
//
//Input: s = "ab"
//Output: 1

public class PalindromePartitioning {

    public static void main(String[] args) {
        String str = "aab";
        System.out.println(findSubstringWithIndex(str, 0, str.length() - 1));
    }

    private static int findSubstringWithIndex(String str, int left, int right) {
        if (left >= right) {
            return 0;
        }
        if (isPalindrome(str, left, right)) {
            return 0;
        }
        int temp = Integer.MAX_VALUE;
        for (int k = left; k <= right - 1; k++) {
            int left_partitions = findSubstringWithIndex(str, left, k);
            int right_partitions = findSubstringWithIndex(str, k + 1, right);
            int totalPartitionsForGivenString = 1 + left_partitions + right_partitions;
            temp = Math.min(temp, totalPartitionsForGivenString);
        }
        return temp;
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
