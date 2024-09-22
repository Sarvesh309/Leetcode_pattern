package Trees.BinaryTree;

import Trees.Node;

import static Trees.Node.buildTree;

//Given the root of a binary tree, return the maximum path sum of any non-empty path.
//A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42

public class MaxSumPath {

    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {

        String input = "-10 9 20 N N 15 7";
        Node root = buildTree(input);
        int maxSum = maxPathSum(root);
        System.out.println(maxSum);
    }

    public static int maxPathSum(Node root) {
        maxSum(root);
        return maxSum;
    }

    static int maxSum(Node node) {
        if (node == null)
            return 0;

        //post order traversal
        int leftTreeSum = maxSum(node.left);
        int rightTreeSum = maxSum(node.right);
        int curr_data = node.data;

        int sum = leftTreeSum + curr_data + rightTreeSum;
        maxSum = Math.max(sum, maxSum);

        int leftContribution = leftTreeSum + curr_data;
        int rightContribution = rightTreeSum + curr_data;

        int toReturn = Math.max(leftContribution, rightContribution);

        return toReturn < 0 ? 0 : toReturn;
    }
}
