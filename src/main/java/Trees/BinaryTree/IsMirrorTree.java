package Trees.BinaryTree;

//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

//Input: root = [1,2,2,3,4,4,3]
//Output: true

import Trees.Node;

public class IsMirrorTree {
    Node root;

    public static void main(String[] args) {
        IsMirrorTree tree = new IsMirrorTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);

        boolean isSymmetric = tree.isSymmetric(tree.root, tree.root);
        System.out.println("Tree is Symmetric: " + isSymmetric);
    }

    boolean isSymmetric(Node leftNode, Node rightNode) {

        if (leftNode == null && rightNode == null)
            return true;

        //This condition is basically simplified version of (left!=null && right==null) || (left==null && right!=null)
        if (leftNode == null || rightNode == null)
            return false;

        if (leftNode.data != rightNode.data)
            return false;

        boolean isLeftSymmetric = isSymmetric(leftNode.left, rightNode.right);
        boolean isRightSymmetric = isSymmetric(leftNode.right, rightNode.left);
        return isLeftSymmetric && isRightSymmetric;
    }
}