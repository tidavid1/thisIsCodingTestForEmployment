package ch05_DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFSExample {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{0,3,4},{0,5,6},{1,7},{1,7},{2,7},{2,7},{3,4,5,6}};
        boolean[] visited = new boolean[graph.length];
        System.out.println("BFS Examples:");
        System.out.println(BFS(graph, 0, visited));
    }

    private static String BFS(int[][] graph, int start, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        visited[start] = true;
        sb.append(start).append("-");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int location = queue.poll();
            for (int i : graph[location]) {
                if (!visited[i]) {
                    sb.append(i).append("-");
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return sb.substring(0, sb.length()-1);
    }
}
