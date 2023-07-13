package ch05_DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFSExample {
    public static String BFS(int[][] graph, int start, boolean[] visited) {
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
