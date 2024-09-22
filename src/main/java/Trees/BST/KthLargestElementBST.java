package Trees.BST;

//Given a Binary Search Tree. Your task is to complete the function which will return the Kth largest
// element without doing any modification in Binary Search Tree.

//Input:
//      4
//    /   \
//   2     9
//k = 2
//Output: 4

//Simply apply reverse inorder ie:- Right Root Left

import Trees.Node;

import static Trees.Node.buildTree;

public class KthLargestElementBST {

    static int kthLargest = -1;
    static int counter = 0;

    public static void main(String[] args) {

        String input = "4 2 9";
        Node root = buildTree(input);
        int k = 2;
        System.out.println(kthLargest(root, k));
    }

    public static int kthLargest(Node root, int K) {
        kLargest(root, K);
        return kthLargest;
    }

    static void kLargest(Node node, int K) {
        if (node == null)
            return;

        //apply reverse inorder ie:- Right Root Left
        kLargest(node.right, K);
        counter++;
        if (counter == K)
            kthLargest = node.data;

        kLargest(node.left, K);
    }
}
