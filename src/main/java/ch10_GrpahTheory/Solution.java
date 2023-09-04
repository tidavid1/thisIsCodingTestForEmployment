package ch10_GrpahTheory;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    // Q1. 팀 결성
    public String question01(int n, int m, int[][] calculations){
        StringBuilder sb = new StringBuilder();
        int[] parents = new int[n+1];
        for(int i=0;i<parents.length;i++) parents[i] = i;
        for (int[] calculation:calculations){
            if (calculation[0] == 0){
                union_parent(parents, calculation[1], calculation[2]);
            }else{
                sb.append(find_parent(parents, calculation[1]) == find_parent(parents, calculation[2])?"YES\n" : "NO\n");
            }
        }
        return sb.toString();
    }

    // Q2. 도시 분할 계획
    public int question02(int n, int m, int[][] information){
        int result = 0;
        int max = 0;
        int[] parents = new int[n+1];
        List<Edge> edges = new ArrayList<>();
        for(int i=0;i<parents.length;i++) parents[i] = i;
        for(int[] info :information){
            edges.add(new Edge(info[0], info[1], info[2]));
        }
        edges = edges.stream().sorted().collect(Collectors.toList());
        for(Edge edge:edges){
            if (find_parent(parents, edge.src()) != find_parent(parents, edge.dst())){
                union_parent(parents, edge.src(), edge.dst());
                result += edge.weight();
                max = edge.weight();
            }
        }
        return result-max;
    }

    // Q3. 커리큘럼
    public int[] question03(int n, int[][] classes){
        int[] inDegree = new int[n];
        int[] time = new int[n];
        int[] result = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            time[i] = classes[i][0];
            for(int j=1;j<classes[i].length;j++){
                inDegree[i] += 1;
                graph.get(classes[i][j]-1).add(i);
            }
        }

        System.arraycopy(time, 0, result, 0, time.length);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i:graph.get(now)){
                result[i] = Math.max(result[i], result[now] + time[i]);
                inDegree[i] -= 1;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        return result;
    }


    private int find_parent(int[] parents, int x){
        if(parents[x] != x){
            parents[x] = find_parent(parents, parents[x]);
        }
        return parents[x];
    }

    private void union_parent(int[] parents, int a, int b){
        a = find_parent(parents, a);
        b = find_parent(parents, b);
        if (a<b) parents[b] = a;
        else parents[a] = b;
    }

    record Edge(int src, int dst, int weight) implements Comparable<Edge>{
        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }
    }
}
