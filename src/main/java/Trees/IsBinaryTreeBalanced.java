package Trees;

import static Trees.Node.buildTree;

//Given a binary tree, determine if it is height-balanced
//A height-balanced binary tree is a binary tree
// in which the depth of the two subtrees of every node never differs by more than one.

//Input: root = [3,9,20,null,null,15,7]
//Output: true

public class IsBinaryTreeBalanced {

    public static void main(String[] args) {
        String input = "3 9 20 N N 15 7";
        Node root = buildTree(input);
        IsBinaryTreeBalanced obj = new IsBinaryTreeBalanced();
        boolean isBalanced = obj.isBalanced(root);
        System.out.println(isBalanced);
    }

    public boolean isBalanced(Node root) {
        return recursion(root);
    }

    boolean recursion(Node node) {
        if (node == null) {
            return true;
        }
        if (findHeight(node) == -1)
            return false;

        return true;
    }

    int findHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
