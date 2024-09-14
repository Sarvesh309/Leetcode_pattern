package Trees;

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

    boolean isSymmetric(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        //This condition is basically simplified version of (left!=null && right==null) || (left==null && right!=null)
        if (left == null || right == null) {
            return false;
        }
        return left.data == right.data && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}