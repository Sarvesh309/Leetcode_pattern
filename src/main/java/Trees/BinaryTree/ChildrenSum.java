package Trees.BinaryTree;

import Trees.Node;

import static Trees.Node.buildTree;


//Given a binary tree having n nodes. Check whether all of its nodes have the value equal to the sum of their child nodes.
// Return 1 if all the nodes in the tree satisfy the given properties, else it return 0.

//Example:-
//Binary tree
//       35
//      /   \
//     20  15
//    /  \  /  \
//   15 5 10 5

//Output:
//1
//Explanation:
//Here, every node is sum of its left and right child.

public class ChildrenSum {
    public static void main(String[] args) {

        String input = "10 10";
        Node root = buildTree(input);

        int isSumProperty = isSumProperty(root);
        System.out.println(isSumProperty);
    }

    public static int isSumProperty(Node root) {
        return isSum(root) ? 1 : 0;
    }

    static boolean isSum(Node node) {
        if (node == null)
            return true;

        if (node.left == null && node.right == null)
            return true;

        int leftVal, rightVal;
        leftVal = rightVal = 0;
        if (node.left != null)
            leftVal = node.left.data;

        if (node.right != null)
            rightVal = node.right.data;

        if (leftVal + rightVal != node.data)
            return false;

        return isSum(node.left) && isSum(node.right);
    }
}
