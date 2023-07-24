package ch09_ShortestPath;
import java.util.*;
import java.util.stream.IntStream;

public class FloydExample {

    public static void setup(Graph graph){
        IntStream.rangeClosed(0,3).forEach(graph::addNode);
        graph.addEdge(0,1,4);
        graph.addEdge(0,3,6);
        graph.addEdge(1,0,3);
        graph.addEdge(1,2,7);
        graph.addEdge(2,0,5);
        graph.addEdge(2,3,4);
        graph.addEdge(3,2,2);
    }
    public static int[][] Floyd(Graph graph){
        int[][] dist = new int[graph.size()][graph.size()];
        for(int i=0;i< dist.length;i++){
            for(int j=0;j<dist[i].length;j++){
                dist[i][j] = i==j?0:1000000;
            }
        }
        for(Edge edge: graph.getEdges()){
            dist[edge.src][edge.dst] = Math.min(dist[edge.src][edge.dst], edge.weight);
        }
        for(int i = 0;i< graph.size();i++){
            for(int j=0;j< graph.size();j++){
                for(int k = 0;k< graph.size();k++){
                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }
        return dist;
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

        public List<Edge> getEdges() {
            return edges;
        }
    }

    record Edge(int src, int dst, int weight){}
}
