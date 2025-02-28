package Graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        List<List<Integer>> adjList;
        adjList = Arrays.asList(Arrays.asList(1, 2, 3), Collections.emptyList(), Collections.singletonList(4), Collections.emptyList(), Arrays.asList());

        int vertices = 5;
        bfs(adjList, vertices);
    }

    //0-> 1,2,3
    //1->
    //2-> 4
    //3->
    //4->
    //IMP - Entry in queue only if element visited
    private static void bfs(List<List<Integer>> adjList, int vertices) {

        List<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[vertices];

        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            result.add(vertex);
            for (Integer neighbour : adjList.get(vertex)) {
                if (!visited[neighbour]) {
                    queue.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
        System.out.println(result);
    }
}
