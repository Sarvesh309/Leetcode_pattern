package Trees.BinaryTree;

import Trees.Node;

import static Trees.Node.buildTree;

//Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
//Input: p = [1,2], q = [1,null,2]
//Output: false

public class AreTreesIdentical {
    public static void main(String[] args) {

        String p = "1 2 3";
        String q = "1 2 3";
        Node nodeP = buildTree(p);
        Node nodeQ = buildTree(q);
        boolean isIdentical = isSameTree(nodeP, nodeQ);
        System.out.println(isIdentical);
    }

    static public boolean isSameTree(Node p, Node q) {
        return isSame(p, q);
    }

    static boolean isSame(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        //preOrder
        if (p.data != q.data) {
            return false;
        }
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
}
