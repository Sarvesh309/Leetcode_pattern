package String;


//Given a string which has some lowercase alphabet characters and one special character dot(.).
// We need to replace all dots with some alphabet character in such a way that resultant string becomes a palindrome
//Input : str = “ab..e.c.a”
//Output : abcaeacba


//The smallest palindrome which can be made
//after replacement is "abcaeacba"
//We replaced first dot with "c", second dot with
//"a", third dot with "a" and fourth dot with "b"

//Input  : str = “ab..e.c.b”
//Output : Not Possible
//It is not possible to convert above string into
//palindrome

public class SmallestPalindromeAfterReplacingDots {

    public static void main(String[] args) {
        System.out.println(smallestPalindromeAfterReplacingDots("ab..e.c.a"));
    }

    // Took 15 minutes - too much time
    private static String smallestPalindromeAfterReplacingDots(String str) {

        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int rearIndex = str.length() - 1 - i;
            if (str.charAt(i) != '.' && str.charAt(rearIndex) != '.' && str.charAt(i) == str.charAt(rearIndex)) {
                result[i] = str.charAt(i);
                result[rearIndex] = str.charAt(i);
            } else if (str.charAt(i) == '.' && str.charAt(rearIndex) == '.') {
                result[i] = 'a';
                result[rearIndex] = 'a';
            } else if (str.charAt(i) == '.' && str.charAt(rearIndex) != '.') {
                result[i] = str.charAt(rearIndex);
                result[rearIndex] = str.charAt(rearIndex);
            } else if (str.charAt(i) != '.' && str.charAt(rearIndex) == '.') {
                result[rearIndex] = str.charAt(i);
                result[i] = str.charAt(i);
            } else if (str.charAt(i) != '.' && str.charAt(rearIndex) != '.' && str.charAt(i) != str.charAt(rearIndex)) {
                return "";
            }
        }
        return String.valueOf(result);
    }
}


