package Trees.BST;


import Trees.Node;

import static Trees.Node.buildTree;


//Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

//The lowest common ancestor is defined between two nodes p and q as the lowest node in T
// that has both p and q as descendants (where we allow a node to be a descendant of itself).”

//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.

public class LCA_BinarySearchTree {
    public static void main(String[] args) {

        String input = "6 2 8 0 4 7 9 N N 3 5 ";
        String p = "2";
        String q = "8";
        Node root = buildTree(input);
        Node pNode = buildTree(p);
        Node qNode = buildTree(q);
        Node LCA = lowestCommonAncestor(root, pNode, qNode);
        System.out.println(LCA);

    }

    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        return recur(root, p, q);
    }

    static Node recur(Node root, Node p, Node q) {

        if (root == null || (root == p || root == q))
            return root;

        int rootVal = root.data;
        int pVal = p.data;
        int qVal = q.data;

        Node maxNode, minNode;
        if (pVal > qVal) {
            maxNode = p;
            minNode = q;
        } else {
            maxNode = q;
            minNode = p;
        }
        if (rootVal > minNode.data && rootVal < maxNode.data)
            return root;

        else if (rootVal > maxNode.data)
            return recur(root.left, p, q);

        else if (rootVal < minNode.data)
            return recur(root.right, p, q);

        return null;
    }
}
