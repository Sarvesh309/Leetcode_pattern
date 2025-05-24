package Trees.BinaryTree;

import Trees.Node;

import static Trees.Node.buildTree;


//Given the root of a binary tree, return its maximum depth.

//A binary tree's maximum depth is the number of nodes along the longest path
// from the root node down to the farthest leaf node.

//Input: root = [1,null,2]
//Output: 2
class HeightOfBinaryTree {
    public static void main(String[] args) {

        String input = "3 9 20 N N 15 7";
        Node root = buildTree(input);

        int maxDepth = maxDepth(root);
        System.out.println(maxDepth);
    }

    static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        //post order
        int leftHeight = maxDepth(node.left);
        int rightHeight = maxDepth(node.right);

        int height = Math.max(leftHeight, rightHeight);
        return height + 1;
    }
}
