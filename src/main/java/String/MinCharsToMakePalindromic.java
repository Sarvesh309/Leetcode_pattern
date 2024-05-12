package String;

//Given a string. The only operation allowed is to insert characters at the beginning of the string.
//Find how many minimum characters are needed to be inserted to make the string a palindrome string.

//Input 1: "ABC"
//Output 1: 2 ==> "CBABC"
//Input 2: "AACECAAAA"
//Output 2: 2 ==> "AAAACECAAAA"

public class MinCharsToMakePalindromic {

    //THE idea is basically to find the largest palindromic substring with beginning character strictly set to 0th
    // character why? because that's will give the optimal solution
    public static void main(String[] args) {
        String str = "ABC";
        int left = 0;
        int global_right = str.length() - 1;
        int temp_right = global_right;

        //
        while (left <= temp_right) {

            //check for every substring whether it is palindromic using two pointers, left at begin, right at end.
            if (str.charAt(left) == str.charAt(temp_right)) {
                left++;
                temp_right--;
            }
            //RESET
            //Pick the next candidate substring, update left pointr to 0 , right to right--
            else {
                left = 0;
                global_right--;
                temp_right = global_right;
            }
        }
        //At the end of while loo[p, global_right will contain the optimal right index
        //Now append the substring starting from end to global_right in the str string to get final answer

        String substring = str.substring(global_right + 1, str.length());
        StringBuilder reversed = new StringBuilder(substring).reverse();

        System.out.println(reversed + str);
    }
}
