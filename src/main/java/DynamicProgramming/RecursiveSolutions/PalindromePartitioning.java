package DynamicProgramming.RecursiveSolutions;

//Given a string s, partition s such that every
//substring of the partition is a palindrome
//Return the minimum cuts needed for a palindrome partitioning of s.
//Example:-
//
//Input: s = "ab"
//Output: 1

public class PalindromePartitioning {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(partitionsInSubstring(str, 0 , str.length()-1));
    }

    private static int partitionsInSubstring(String str, int startIndex, int endIndex) {
        if(startIndex==endIndex)
            return 0;

        if(startIndex>endIndex)
            return 0;

        if (isPalindromic(str, startIndex,endIndex)) {
            return 0;
        }
        int temp = Integer.MAX_VALUE;
        for(int partitionIndex = startIndex; partitionIndex <= endIndex -1 ; partitionIndex++){
            temp = Math.min(temp, (partitionsInSubstring(str, startIndex, partitionIndex) +
                    partitionsInSubstring(str, partitionIndex + 1, endIndex))+1);
        }
        return temp;
    }

    private static boolean isPalindromic(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
