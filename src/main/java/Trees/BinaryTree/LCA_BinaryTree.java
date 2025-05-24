package Trees.BinaryTree;

import Trees.Node;

import static Trees.Node.buildTree;


//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree
//The lowest common ancestor is defined between two nodes p and q as the lowest node in T
//that has both p and q as descendants (where we allow a node to be a descendant of itself)

//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3
public class LCA_BinaryTree {

    static Node LCANode;

    public static void main(String[] args) {
        String rootInput = "3 5 1 6 2 0 8 N N 7 4";
        String node1 = "5";
        String node2 = "1";
        Node root = buildTree(rootInput);
        Node p = buildTree(node1);
        Node q = buildTree(node2);

        isAnyGivenNodePresent(root, p, q);

        System.out.println(LCANode);
    }

    static boolean isAnyGivenNodePresent(Node currNode, Node p, Node q) {
        if (currNode == null)
            return false;

        if (currNode.data == p.data || currNode.data == q.data) {
            //initial lca candidate
            LCANode = currNode == p ? p : q;
            return true;
        }

        boolean isPresentInLeftSubTree = isAnyGivenNodePresent(currNode.left, p, q);
        boolean isPresentInRightSubTree = isAnyGivenNodePresent(currNode.right, p, q);

        if (isPresentInLeftSubTree && isPresentInRightSubTree) {
            //overwrite
            LCANode = currNode;
        }

        return isPresentInLeftSubTree || isPresentInRightSubTree;
    }
}
