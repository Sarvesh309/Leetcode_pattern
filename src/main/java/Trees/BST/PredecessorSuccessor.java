package Trees.BST;

import Trees.Node;

import static Trees.Node.buildTree;


//There is BST given with the root node with the key part as an integer only. find the in-order successor and predecessor of a given key.
//If either predecessor or successor is not found, then set it to NULL.

//Input:
//      8
//    /   \
//   1     9
//    \     \
//     4    10
//    /
//   3
//key = 8
//Output: 4 9

public class PredecessorSuccessor {
    public static void main(String[] args) {

        String input = "10 2 11 1 5 N N N N 3 6 N 4";
        Node root = buildTree(input);
        int key = 8;
        Node[] pre = new Node[1];
        Node[] suc = new Node[1];
        findPreSuc(root, pre, suc, key);
        System.out.println(pre[0]);
        System.out.println(suc[0]);
    }

    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key

        pre[0] = null;
        suc[0] = null;

        if (key > root.data)
            searchInRightSubTree(root, pre, key, suc);
        else
            searchInLeftSubTree(root, pre, key, suc);
    }

    static void searchInLeftSubTree(Node node, Node[] pre, int key, Node[] suc) {

        if (node == null)
            return;

        if (node.data > key) {
            searchInRightSubTree(node, pre, key, suc);
        }

        if (pre[0] == null && node.data < key)
            pre[0] = node;

        else if (node.data < key)
            pre[0] = (pre[0] != null && pre[0].data > node.data) ? pre[0] : node;

        searchInLeftSubTree(node.right, pre, key, suc);
        searchInLeftSubTree(node.left, pre, key, suc);
    }

    static void searchInRightSubTree(Node node, Node[] pre, int key, Node[] suc) {
        if (node == null)
            return;

        if (node.data < key) {
            searchInLeftSubTree(node, pre, key, suc);
        }

        if (suc[0] == null && node.data > key)
            suc[0] = node;

        else if (node.data > key)
            suc[0] = (suc[0] != null && suc[0].data < node.data) ? suc[0] : node;


        searchInRightSubTree(node.left, pre, key, suc);
        searchInRightSubTree(node.right, pre, key, suc);
    }
}
