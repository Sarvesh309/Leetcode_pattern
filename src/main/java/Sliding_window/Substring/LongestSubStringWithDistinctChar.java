package Sliding_window.Substring;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithDistinctChar {
    public static void main(String[] args) {
        String str = "findlongestsubstring";
        String result = longestSubstringWithDistinctChar(str);
        System.out.println(result);
    }

    private static String longestSubstringWithDistinctChar(String str) {
        int left = 0;
        int right = 0;
        String result = "";
        Map<Character, Integer> mp = new HashMap<>();
        while (right < str.length()) {

            //1st step to slide the right pointer and add the elements in the map
            char curr_ch = str.charAt(right);
            mp.put(curr_ch, mp.getOrDefault(curr_ch, 0) + 1);



            //2nd step is to remove the characters until cetain condition is met
            while (mp.get(str.charAt(right)) > 1) {
                char leftChar = str.charAt(left);
                mp.put(leftChar, mp.get(leftChar) - 1);

                if (mp.get(leftChar) == 0) {
                    mp.remove(leftChar);
                }
                left++;
            }

            //Capture the result here in 3rd step
            if (result.length() < right - left + 1) {
                result = str.substring(left, right + 1);
            }

            //4th and most important step increment the right pointer
            right++;
        }
        return result;
    }
}
