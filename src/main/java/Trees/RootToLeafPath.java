package Trees;

//Given a Binary Tree of nodes,
// find all the possible paths from the root node to all the leaf nodes of the binary tree.

//Input:
//       1
//    /     \
//   2       3
//Output:
//1 2
//1 3

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Trees.Node.buildTree;

class RootToLeafPath {
    public static void main(String[] args) throws IOException {
        String input = "1 3 2";
        Node root = buildTree(input);

        RootToLeafPath obj = new RootToLeafPath();
        List<List<Integer>> result = obj.paths(root);
        result.forEach(System.out::print);
    }

    public List<List<Integer>> paths(Node root) {

        List<List<Integer>> result = recursion(root);
        for (List<Integer> list : result)
            Collections.reverse(list);
        return result;
    }

    public List<List<Integer>> recursion(Node node) {
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> subList = new ArrayList<>();
            subList.add(node.data);
            result.add(subList);
            return result;
        }

        List<List<Integer>> leftTreeResult = recursion(node.left);
        List<List<Integer>> rightTreeResult = recursion(node.right);

        List<List<Integer>> newList = new ArrayList<>();
        if (leftTreeResult != null) {
            for (List<Integer> leftList : leftTreeResult)
                leftList.add(node.data);
            newList.addAll(leftTreeResult);
        }

        if (rightTreeResult != null) {
            for (List<Integer> rightList : rightTreeResult)
                rightList.add(node.data);
            newList.addAll(rightTreeResult);
        }
        return newList;
    }
}
