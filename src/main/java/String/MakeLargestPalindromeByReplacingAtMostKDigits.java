package String;

//You are given a string s consisting of digits (0-9) and an integer k. Convert the string into a palindrome by changing at most k digits.
// If multiple palindromes are possible, return the lexicographically largest one.
// If it's impossible to form a palindrome with k changes, return "Not Possible".

//Input:  s = “19495”, k = 3
//Output: "99999"

//Input:  s = “43436”, k = 1
//Output: “63436”

//Input: s = “11345”, k = 1
//Output: "Not Possible"

public class MakeLargestPalindromeByReplacingAtMostKDigits {

    public static void main(String[] args) {
        String s = "43436";
        int k = 1;
        System.out.println(maxpalindrome(s, k));
    }

    private static String maxpalindrome(String s, int k) {
        int left = 0;
        int right = s.length() - 1;
        int length = s.length();

        int unEqualCount = 0;
        char[] charArray = s.toCharArray();
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                unEqualCount++;
                char value = (char) Math.max(s.charAt(left), s.charAt(right));
                charArray[left] = value;
                charArray[right] = value;
            }
            left++;
            right--;
        }
        if (unEqualCount > k) {
            return "NOT POSSIBLE";
        }
        int l = length;
        String res = "";

        if (length % 2 == 0 && 2 * unEqualCount <= k) {
            while (l-- > 0) {
                res += "9";
            }
        } else if (length % 2 == 1 && 2 * unEqualCount + 1 <= k) {
            while (l-- > 0) {
                res += "9";
            }
        }
        return res != "" ? res : String.valueOf(charArray);
    }
}
