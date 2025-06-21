package String;
import java.util.Arrays;


//Given a string S. Print the lexicographically smallest string possible.
//You have to make minimal changes(Replacements) to the characters in the string and you can permute the string.
//Input : S = "aabcd"
//Output : "abcba"    ==> Permutation with 1 replacement lexicographically smallest

// Preference 1 => minimum replacements
// preference 2 -> lexicographically smallest

//Input : S = "aabc"
//Output : "abba"

public class LexiSmallestPalindromeWithMinReplacements {

    public static void main(String[] args) {
        String str = "abcba";
        System.out.println(smallestPalindrome(str));
    }

    private static String smallestPalindrome(String str) {

        int[] freq = new int[26];

        str.chars().mapToObj(ch -> (char) ch).
                forEach(ch -> freq[ch - 'a']++);
        System.out.println(Arrays.toString(freq));
        String oddChars = "";

        for(char ch = 'a'; ch<='z'; ch++){
            if((freq[ch-'a']%2)!=0){
                oddChars+=ch;
            }
        }
        // abcd
        // abcde
        // Odd characters manipulation - lexicographically arranging, take care of odd / even length, middle element, Adjust frequency array.
        char[] oddCharArray = oddChars.toCharArray();
        for (int i = 0; i < oddCharArray.length / 2; i++) {
            freq[oddCharArray[i] - 'a']++;
            freq[oddCharArray[oddCharArray.length - 1 - i] - 'a']--;
            oddCharArray[oddCharArray.length - 1 - i] = oddCharArray[i];     // Pairing in General here it' for palindrome
        }

        // Palindrome Creation Step

        // Time complexity for this block
        // Outer for loop - > 26 times
        // inner while loop -> O(N) TC
        // overall TC -> O(KN)
        // k = 26

        char[] result = new char[str.length()];
        int front = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (freq[ch - 'a'] % 2 == 0) {
                while(freq[ch - 'a']>0) {
                    result[front] = result[result.length - 1 - front] = ch;
                    freq[ch - 'a'] -= 2;
                    front++;
                }
            }
            else if (freq[ch - 'a'] % 2 == 1) {
                result[result.length / 2] = ch;
                freq[ch - 'a']--;
            }
        }
        return Arrays.toString(result);
    }
}
