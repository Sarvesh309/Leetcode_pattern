package Stack;

import java.util.Arrays;
import java.util.Stack;

//DECREASING_MONOTONIC STACK
//Given an array of positive integers A, find the first greater number for every element on its right.
// If a greater number does not exist, use -1.
//
//Example:
//Input: [1, 5, 2, 3, 5]
//Output: [5, -1, 3, 5, -1]
//Time Complexity:- O(N)

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 3, 5};
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        //This stack contains the indexes of monotonic decreasing elements
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            //If any smaller element arrives, push the indexes of smaller elements making it the monotonic decreasing stack
                if (arr[i] < arr[stack.peek()]) {
                    stack.push(i);

                } else if (arr[i] >= arr[stack.peek()]) {
                    // If any greater element arrives, we will pop the top index from stack and
                    // for every poped index in result array we will update the current element's value against it
                    // we will do this until there is no greater element than current element left in our monotonic stack
                    if (!stack.isEmpty()) {
                        while (arr[stack.peek()]<arr[i]) {
                            if (!stack.isEmpty()) {
                                int top_index = stack.pop();
                                res[top_index] = arr[i];
                            }
                        }
                    }
                }
        }
        System.out.println(Arrays.toString(res));
    }
}
