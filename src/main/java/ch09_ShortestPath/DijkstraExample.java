package ch09_ShortestPath;

import java.util.*;
import java.util.stream.*;

public class DijkstraExample {

    static void setup(Graph graph){
        IntStream.rangeClosed(1, 6).forEach(graph::addNode);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 2, 3);
        graph.addEdge(3, 6, 5);
        graph.addEdge(4, 3, 3);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 3, 1);
        graph.addEdge(5, 6, 2);
    }
    public static int[] Dijkstra(int start, Graph graph){
        int[] distances = new int[graph.size()+1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(Integer.MAX_VALUE, start, 0));
        while(!queue.isEmpty()){
            Edge currentEdge = queue.poll();
            if(distances[currentEdge.dst] < currentEdge.weight)
                continue;
            for(Edge edge:graph.getConnectedEdges(currentEdge.dst)){
                int changeWeight = currentEdge.weight + edge.weight;
                if (changeWeight < distances[edge.dst]){
                    distances[edge.dst] = changeWeight;
                    queue.add(new Edge(edge.src, edge.dst, changeWeight));
                }
            }
        }
        return distances;
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
            if(nodes.contains(src) && nodes.contains(dst)) {
                edges.add(new Edge(src, dst, weight));
            }
        }
        List<Edge> getConnectedEdges(int node){
            return edges.stream().filter(edge -> edge.src == node).collect(Collectors.toList());
        }
    }

    record Edge(int src, int dst, int weight) implements Comparable<Edge> {
        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }
    }

}
