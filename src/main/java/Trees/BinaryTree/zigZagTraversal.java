package Trees.BinaryTree;

import Trees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static Trees.Node.buildTree;

//Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
// (i.e., from left to right, then right to left for the next level and alternate between).

//Input: root = [3,9,20,null,null,15,7] - level ordered input
//Output: [[3],[20,9],[15,7]]

public class zigZagTraversal {
    public static void main(String[] args) {

        String input = "3 9 20 N N 15 7";
        Node root = buildTree(input);
        List<List<Integer>> zigZagOrderList = zigzagLevelOrder(root);
        System.out.println(zigZagOrderList);
    }

    public static List<List<Integer>> zigzagLevelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null)
            stack.add(root);

        boolean leftToRight = false;
        while (!stack.isEmpty()) {

            int currLevelSize = stack.size();

            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < currLevelSize; i++) {
                Node node = stack.pop();
                levelList.add(node.data);
                if (leftToRight) {
                    if (node.right != null)
                        stack.add(node.right);

                    if (node.left != null)
                        stack.add(node.left);

                } else {
                    if (node.left != null)
                        stack.add(node.left);

                    if (node.right != null)
                        stack.add(node.right);
                }
            }
            result.add(levelList);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
