package ch09_ShortestPath;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    // Q1. 미래 도시
    public int question01(int n, int m, int[][] directions, int k, int x){
        Graph graph = new Graph();
        IntStream.rangeClosed(1, n).forEach(graph::addNode);
        for(int[] direction: directions){
            graph.addEdge(direction[0], direction[1], 1);
            graph.addEdge(direction[1], direction[0], 1);
        }
        int[][] dist = new int[graph.size()+1][graph.size()+1];
        for(int i=1;i<dist.length;i++){
            for(int j=1;j<dist[i].length;j++){
                dist[i][j] = i == j ? 0 : 1000000;
            }
        }
        for(Edge edge: graph.getEdges()){
            dist[edge.src][edge.dst] = Math.min(dist[edge.src][edge.dst], edge.weight);
        }
        for(int i=1;i< dist.length;i++){
            for(int j=1;j<dist.length;j++){
                for(int l=1;l<dist[j].length;l++){
                    dist[j][l] = Math.min(dist[j][l], dist[j][i]+dist[i][l]);
                }
            }
        }
        return dist[1][k]+dist[k][x] > 1000000 ? -1 :dist[1][k]+dist[k][x];
    }

    // Q2. 전보
    public int[] question02(int n, int m, int c, int[][] directions){
        int[] answer = new int[]{0,0};
        Graph graph = new Graph();
        IntStream.rangeClosed(1, n).forEach(graph::addNode);
        for(int[] direction:directions){
            graph.addEdge(direction[0], direction[1], direction[2]);
        }
        int[] distances = new int[graph.size()+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[c] = 0;
        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(Integer.MAX_VALUE, c, 0));
        while(!queue.isEmpty()){
            Edge currentEdge = queue.poll();
            if(distances[currentEdge.dst] < currentEdge.weight){
                continue;
            }
            for(Edge edge:graph.getConnectedEdges(currentEdge.dst)){
                int changeWeight = currentEdge.weight + edge.weight;
                if(changeWeight < distances[edge.dst]){
                    distances[edge.dst] = changeWeight;
                    queue.add(new Edge(edge.src, edge.dst, changeWeight));
                }
            }
        }
        for(int distance:distances){
            if (distance != Integer.MAX_VALUE && distance != 0){
                answer[0] += 1;
                answer[1] = Math.max(answer[1], distance);
            }
        }
        return answer;
    }

    static class Graph{
        private final Set<Integer> nodes;
        private final List<Edge> edges;

        public Graph(){
            this.nodes = new HashSet<>();
            this.edges = new ArrayList<>();
        }
        void addNode(int node){
            nodes.add(node);
        }
        int size(){
            return nodes.size();
        }
        void addEdge(int src, int dst, int weight){
            if(nodes.contains(src) && nodes.contains(dst)){
                if(edges.contains(new Edge(src, dst, weight))){
                    return;
                }
                edges.add(new Edge(src, dst, weight));
            }
        }
        public List<Edge> getEdges(){
            return edges;
        }

        public List<Edge> getConnectedEdges(int node){
            return edges.stream().filter(edge -> edge.src == node).collect(Collectors.toList());
        }

    }

    record Edge(int src, int dst, int weight) implements Comparable<Edge>{
        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }
    }
}
