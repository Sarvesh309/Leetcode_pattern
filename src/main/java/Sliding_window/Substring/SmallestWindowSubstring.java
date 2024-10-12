package Sliding_window.Substring;

import java.util.HashMap;
import java.util.Map;

//Smallest window in a string containing all the characters of another string
//Input: string = “this is a test string”, pattern = “tist”
//Output: “t stri”
public class SmallestWindowSubstring {
    public static void main(String[] args) {
        String input = "this is a test string";
        String pattern = "tist";

        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int start_index = 0;
        Map<Character, Integer> patternMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
        }
        System.out.println(patternMap);
        while (right < input.length()) {

            boolean allMatch = isAllMatch(patternMap, map);
            if (!allMatch) {
                char ch = input.charAt(right);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            } else {
                result = Math.min(result, right - left + 1);
                start_index = left;
                while (isAllMatch(patternMap, map)) {
                    char ch_mp = input.charAt(left);
                    if (map.get(ch_mp)!=null) {
                        map.put(ch_mp, map.get(ch_mp) - 1);
                        if (map.get(ch_mp) == 0) {
                            map.remove(ch_mp);
                        }
                    }
                    left++;
                }
            }
            right++;
        }

        System.out.println(input.substring(start_index, start_index + result));
    }

    private static boolean isAllMatch(Map<Character, Integer> patternMap, Map<Character, Integer> map) {
        return patternMap.keySet().stream().allMatch(map::containsKey);
    }
}
