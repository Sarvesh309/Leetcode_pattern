package Trees.BinaryTree;

import Trees.Node;

import static Trees.Node.buildTree;


//The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
// This path may or may not pass through the root.

//Input: root = [1,2,3,4,5]
//Output: 3
//Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3]

public class DiameterOfBinaryTree {

    static int max_nodes = Integer.MIN_VALUE;

    public static void main(String[] args) {
        String input = "1 2 3 4 5";
        Node root = buildTree(input);

        int diameter = diameterOfBinaryTree(root);
        System.out.println(diameter);
    }

    public static int diameterOfBinaryTree(Node root) {
        //postorder
        recursion(root);
        int max_edges = max_nodes - 1;
        return max_edges;
    }

    static int recursion(Node node) {
        if (node == null) {
            return 0;
        }
        int left_nodes = recursion(node.left);
        int right_nodes = recursion(node.right);
        int nodes = left_nodes + right_nodes + 1;
        if (nodes > max_nodes) {
            max_nodes = nodes;
        }
        return Math.max(left_nodes, right_nodes) + 1;
    }
}
