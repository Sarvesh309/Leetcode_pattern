package String;

import java.util.ArrayDeque;

//Given string num representing a non-negative integer num, and an integer k,
// return the smallest possible integer after removing k digits from num.

//Input: num = "1432219", k = 3
//Output: "1219"
//Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

public class RemoveKDigits {
    public static void main(String[] args) {

        String num = "10";
        int k=2;

        // Monotonic increasing stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i< num.length(); i++){
            if(i==0)
                stack.push(Integer.valueOf(String.valueOf(num.charAt(0))));

            else{
                char ch = num.charAt(i);
                int value = Integer.parseInt(String.valueOf(ch));
                while(!stack.isEmpty() && stack.peek() > value && k>0){
                    stack.pop();
                    k--;
                }
                stack.push(value);
            }
        }

        String res = "";
        int stackSize = stack.size();
        for(int i = 0; i< stackSize; i++){
            res = stack.pop() + res;
        }
        System.out.println(res);
    }
}
