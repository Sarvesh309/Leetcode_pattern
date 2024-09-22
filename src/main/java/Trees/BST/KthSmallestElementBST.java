package Trees.BST;

import Trees.Node;

import static Trees.Node.buildTree;

//Given the root of a binary search tree, and an integer k,
// return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

//Ex:-
//Input: root = [3,1,4,null,2], k = 1
//Output: 1

public class KthSmallestElementBST {
    static int kthSmallestElement = -1;
    static int counter = 0;

    public static void main(String[] args) {
        String input = "5 3 6 2 4 N N 1";
        Node root = buildTree(input);
        int k = 3;
        kthSmallest(root, k);
        System.out.println(kthSmallestElement);
    }

    public static void kthSmallest(Node root, int k) {
        kSmallest(root, k);
    }

    static void kSmallest(Node node, int k) {
        if (node == null)
            return;

        kSmallest(node.left, k);
        counter++;
        if (counter == k)
            kthSmallestElement = node.data;

        kSmallest(node.right, k);
    }
}
