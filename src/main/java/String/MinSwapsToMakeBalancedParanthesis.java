package String;

import java.util.Deque;
import java.util.LinkedList;

//You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '['
// and n / 2 closing brackets ']'.
//
//A string is called balanced if and only if: It is the empty string, or
//It can be written as AB, where both A and B are balanced strings, or It can be written as [C], where C is a balanced string.
//You may swap the brackets at any two indices any number of times.
//
//Return the minimum number of swaps to make s balanced.

//Input: s = "][]["
//Output: 1
//Explanation: You can make the string balanced by swapping index 0 with index 3.
//The resulting string is "[[]]".

public class MinSwapsToMakeBalancedParanthesis {
    public static void main(String[] args) {

        Deque<Character> stack = new LinkedList<>();
        String s = "][][";

        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    stack.push(']');
                } else if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                }
            }
        }
        stack.forEach(System.out::println);
    }
}
