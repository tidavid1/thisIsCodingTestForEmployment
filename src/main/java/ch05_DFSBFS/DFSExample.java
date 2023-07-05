package ch05_DFSBFS;

import java.util.Stack;

public class DFSExample {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{0,3,4},{0,5,6},{1,7},{1,7},{2,7},{2,7},{3,4,5,6}};
        boolean[] visited = new boolean[graph.length];
        System.out.println("DFS Examples:");
        System.out.println(DFS(graph, 0, visited));
    }

    private static String DFS(int[][] graph, int start, boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        visited[start] = true;
        sb.append(start).append("-");
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()){
            int location = stack.peek();
            boolean flag = true;
            for(int i:graph[location]){
                if(!visited[i]){
                    sb.append(i).append("-");
                    stack.push(i);
                    visited[i] = true;
                    flag = false;
                    break;
                }
            }
            if(flag){
                stack.pop();
            }

        }

        return sb.substring(0,sb.length()-1);
    }
}
