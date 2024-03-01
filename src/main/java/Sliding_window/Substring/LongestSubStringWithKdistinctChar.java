package Sliding_window.Substring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKdistinctChar {

    public static String findLongestSubstring(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return "";
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int start = 0;

        Map<Character, Integer> map = new HashMap<>();

        //Run until the right pointer reaches the last index of the string
        while (right < s.length()) {

            //Insert the elements normally in the map and increase their count
            char currentChar = s.charAt(right);
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            //Pop the left most elements from map and increase the left pointer until the map is empty
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                //increase the left pointer to remove elements from map
                left++;
            }

            //when the elements in map is equal to the k, update the result
            if (map.size()==k) {
                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
            //Increase the right pointer
            right++;
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s = "abcbdbdbbdcdabd";
        int k = 2;
        System.out.println(findLongestSubstring(s, k)); // Output: "bdbdbbd"
    }
}
