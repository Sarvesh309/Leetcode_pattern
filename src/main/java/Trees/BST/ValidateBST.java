package Trees.BST;

import Trees.Node;

import static Trees.Node.buildTree;

//Given the root of a binary tree, determine if it is a valid binary search tree (BST).
//A valid BST is defined as follows:

//1. The left subtree of a node contains only nodes with keys less than the node's key.
//2. The right subtree of a node contains only nodes with keys greater than the node's key.
//3. Both the left and right subtrees must also be binary search trees.

//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.

public class ValidateBST {

    public static void main(String[] args) {
        String input = "4 2 7 1 3";
        Node root = buildTree(input);
        isValidBST(root);
    }

    public static boolean isValidBST(Node root) {
        return check(root);
    }

    static boolean check(Node node) {
        if (node == null)
            return true;

        // PRE-ORDER
        // YOU can choose any traversal type, postorder would be fastest at cases - depends on the false condition node
        long rightmin = recurLeft(node.right);
        long leftmax = recurRight(node.left);

        if (node.data <= leftmax || node.data >= rightmin)
            return false;

        return check(node.left) && check(node.right);
    }

    static long recurLeft(Node node) {
        if (node == null)
            return Long.MAX_VALUE;

        return Math.min(node.data, recurLeft(node.left));
    }

    static long recurRight(Node node) {
        if (node == null)
            return Long.MIN_VALUE;

        return Math.max(node.data, recurRight(node.right));
    }
}

