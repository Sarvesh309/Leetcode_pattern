package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        List<List<Integer>> adjList;
        adjList = Arrays.asList(Arrays.asList(1, 3), Arrays.asList(2, 0), Arrays.asList(1), Arrays.asList(0));

        int vertices = 4;
        boolean[] visited = new boolean[vertices];
        List<Integer> result = new LinkedList<>();
        dfs(adjList, 0, visited, result);
        System.out.println(result);
    }

    private static void dfs(List<List<Integer>> adjList, int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);

        //Before exploration of neighbours or children
        for (Integer neighbour : adjList.get(vertex)) {
            if (!visited[neighbour]) {
                //Before exploration of individual children
                dfs(adjList, neighbour, visited, result);
            }
            //after exploration of children
        }
        //after exploration of all children
        return;
    }
}
