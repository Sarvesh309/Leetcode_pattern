package Trees.BinaryTree;

import Trees.Node;

import java.util.ArrayList;
import java.util.List;

import static Trees.Node.buildTree;

//You are given a binary tree having 'n' nodes.
//Figure out the boundary nodes of this binary tree in an Anti-Clockwise direction starting from the root node.
//The boundary nodes of a binary tree include the nodes from the left and right boundaries
// and the leaf nodes, each node considered once.

//Sample Input 1:
//10 5 20 3 8 18 25 -1 -1 7 -1 -1 -1 -1 -1 -1 -1
//Sample Output 1:
//10 5 3 7 18 25 20

//The nodes on the left boundary are [10, 5, 3]
//The nodes on the right boundary are [10, 20, 25]
//The leaf nodes are [3, 7, 18, 25].

public class BoundaryTraversal {

    public static void main(String[] args) {
        String input = "10 5 20 3 8 18 25 N N 7 N N N N N";
        Node root = buildTree(input);
        List<Integer> result = traverseBoundary(root);
        System.out.println(result);
    }

    public static List<Integer> traverseBoundary(Node root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        List<Integer> bottomList = new ArrayList<>();

        result.add(root.data);

        leftBoundryTraversal(root.left, leftList);
        result.addAll(leftList);

        BottomBoundryTraversal(root, bottomList);
        result.addAll(bottomList);

        rightBoundryTraversal(root.right, rightList);
        result.addAll(rightList);

        return result;
    }

    static void BottomBoundryTraversal(Node node, List<Integer> bottomList) {
        if (node == null)
            return;

        if (node.left == null && node.right == null)
            bottomList.add(node.data);
        BottomBoundryTraversal(node.left, bottomList);
        BottomBoundryTraversal(node.right, bottomList);
        return;
    }

    static void leftBoundryTraversal(Node node, List<Integer> leftList) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null)
            return;
        leftList.add(node.data);
        if (node.left != null)
            leftBoundryTraversal(node.left, leftList);

        else if (node.right != null)
            leftBoundryTraversal(node.right, leftList);
        return;
    }

    static void rightBoundryTraversal(Node node, List<Integer> rightList) {
        if (node == null)
            return;

        if (node.left == null && node.right == null)
            return;

        if (node.right != null)
            rightBoundryTraversal(node.right, rightList);

        else if (node.left != null)
            rightBoundryTraversal(node.left, rightList);

        rightList.add(node.data);
        return;
    }
}
