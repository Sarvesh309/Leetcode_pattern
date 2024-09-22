package Trees.BST;

import Trees.Node;

import static Trees.Node.buildTree;

//You are given the root of a binary search tree (BST) and an integer val.
//
//Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
//If such a node does not exist, return null.

//Input: root = [4,2,7,1,3], val = 2
//Output: [2,1,3]

public class SearchInBST {
    public static void main(String[] args) {

        String input = "4 2 7 1 3";
        int val = 2;
        Node root = buildTree(input);

        Node node = searchBST(root, val);
        System.out.println(node);
    }

    public static Node searchBST(Node root, int val) {
        return search(root, val);
    }

    static Node search(Node node, int val) {
        if (node == null)
            return null;

        if (node.data == val)
            return node;

        else if (val < node.data)
            return search(node.left, val);

        else if (val > node.data)
            return search(node.right, val);

        return null;
    }
}
