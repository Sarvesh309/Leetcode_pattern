package Sliding_window.Substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Given a string s, return the maximum number of occurrences of any substring under the following rules:
//
//The number of unique characters in the substring must be less than or equal to maxLetters.
//The substring size must be between minSize and maxSize inclusive.

//Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
//Output: 2
//Explanation: Substring "aab" has 2 occurrences in the original string.
//It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).

// Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
//Output: 2
//Explanation: Substring "aaa" occur 2 times in the string. It can overlap


// PROBLEM DECOMPOSITION, DEDUCED PROBLEM-PATTERN IDENTIFICATION, THE GIVEN QUESTION IS NEVER A PROBLEM - THE DEDUCED PROBLEM IS THE PROBLEM
// WHOLE SOLUTION IS - DEDUCING THE PROBLEM IN SOME PATTERN & THEN SOLVING THAT PATTERN

public class MaxOccurrencesOfSubString {

    public static void main(String[] args) {

        String s = "aaaa";
        int maxLetters = 1;
        int minSize = 3;
        int maxSize = 3;
        System.out.println(modifiedSlidingWindow(s, maxLetters, minSize, maxSize));
    }

    static int modifiedSlidingWindow(String s, int maxLetters, int minSize, int maxSize) {

        String temp = "";
        int maxSizeSubstring = 0;
        HashMap<String, Integer> result = new HashMap<>();

        for (int start = 0; start <= s.length() - minSize; start++) {                                    // this part is crucial & tedious
            for (int end = (start + minSize); end <= (start + maxSize) && end <= s.length(); end++) {    // this part is crucial & tedious

                Set<Character> freq = new HashSet<>();
                temp = s.substring(start, end);

                if (isValid(temp, freq, maxLetters)) {
                    result.put(temp, result.getOrDefault(temp, 0) + 1);
                    maxSizeSubstring = Math.max(maxSizeSubstring, result.get(temp));
                }
            }
        }
        return maxSizeSubstring;
    }

    static boolean isValid(String str, Set<Character> freq, int maxLetters) {
        for (char ch : str.toCharArray()) {
            freq.add(ch);
        }
        if (freq.size() > maxLetters) {
            return false;
        }
        return true;
    }
}
