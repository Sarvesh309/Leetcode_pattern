package Trees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Trees.Node.buildTree;

//Given a Binary Tree, return its Left view.
// The left view of a Binary Tree is a set of nodes visible when the tree is visited from the Left side.
// If no left view is possible, return an empty array.

class LeftView {

    int max = -1;

    public static void main(String[] args) throws IOException {
        String input = "1 3 2";
        Node root = buildTree(input);

        LeftView obj = new LeftView();
        List<Integer> result = new ArrayList<>();
        int curr_level = 0;

        obj.DFS(curr_level, result, root);
        result.forEach(System.out::print);
    }

    void DFS(int curr_level, List<Integer> result, Node root) {
        if (root == null) {
            return;
        }
        if (curr_level > this.max) {
            result.add(root.data);
            this.max = curr_level;
        }
        DFS(curr_level + 1, result, root.left);
        DFS(curr_level + 1, result, root.right);
    }
}




