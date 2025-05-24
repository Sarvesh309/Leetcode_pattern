package Graph;

// aka Kahn's Algorithm
// also Topological sorting using BFS

import java.util.*;

public class DetectCycleDirectedGraphBFS {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int numCourses = 4;


        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // Initialize the adjacency list with empty lists
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // Fill the adjacency list with edges
        for (int[] prerequisite : arr) {
            int parent = prerequisite[0];
            int child = prerequisite[1];
            adj.get(parent).add(child); // Directed edge from child to parent
        }

        int totalVertices = adj.size();

        int[] inDegree = new int[totalVertices];
        Arrays.fill(inDegree, 0);

        for (int[] edges : arr) {
            inDegree[edges[1]] = inDegree[edges[1]] + 1;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (Integer i : adj.get(node)) {
                inDegree[i]--;

                if (inDegree[i]==0)
                    queue.offer(i);
            }
        }
        //At the end if all the nodes are processed successfully ie:- they get inside the queue and get
        //processed then it's no cycle otherwise later case

        if (result.size()==totalVertices){
            System.out.println(result);
        }
    }
}
