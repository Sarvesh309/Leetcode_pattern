package Priority_queue;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class FirstKNonRepCharacters {
    public static void main(String[] args) {
        String str = "ABCDBAGHCHFAC";
        int k = 3;

        LinkedHashMap<Character, Integer> mp = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        LinkedList<Character> result = new LinkedList<>();

        for (Character ch : mp.keySet()) {
            if (k >= 0) {
                if (mp.get(ch) == 1) {
                    result.add(ch);
                    k--;
                }
            }
        }
        System.out.println(result);
    }
}

