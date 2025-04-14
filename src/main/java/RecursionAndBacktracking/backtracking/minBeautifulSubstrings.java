package RecursionAndBacktracking.backtracking;

//Given a binary string s, partition the string into one or more substrings such that each substring is beautiful.
//
//A string is beautiful if:
//
//It doesn't contain leading zeros.
//It's the binary representation of a number that is a power of 5.
//Return the minimum number of substrings in such partition. If it is impossible to partition the string s into beautiful substrings, return -1.


//Input: s = "1011"
//Output: 2
//Explanation: We can paritition the given string into ["101", "1"].
//- The string "101" does not contain leading zeros and is the binary representation of integer 5^1 = 5.
//- The string "1" does not contain leading zeros and is the binary representation of integer 5^0 = 1.

public class minBeautifulSubstrings {
    static Integer result = Integer.MAX_VALUE;
    public static void main(String[] args) {

        String str = "1011";

        dfs(str, "");
        System.out.println(result);
    }

    //BASIC INPUT OUTPUT METHOD case
    static void dfs(String input, String output){

        if(input.length()==0){
            result = Math.min(output.split(",").length, result);
            return;
        }

        for(int i=0; i < input.length(); i++){
            if(isValid(input, i)){
                String prefix = input.substring(0, i + 1);
                String newOutput = output.equals("") ? output + prefix : output + "," + prefix;
                String newInput = input.substring(i+1);
                dfs(newInput, newOutput);
            }
        }
    }
    static boolean isValid(String input, Integer end){

        String newOutput = input.substring(0, end+1);
        if(newOutput.endsWith("0"))
            return false;

        double sum=0;
        for (int i = 0; i <newOutput.length() ; i++) {
            int digit = Integer.valueOf(Character.toString(newOutput.charAt(i)));
            double v = Math.pow(2, newOutput.length()-1-i) * digit;
            sum=sum+v;
        }
        if(sum% 5 ==0 || sum==1)
            return true;

        return false;
    }
}
