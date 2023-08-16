package ch10_GrpahTheory;

import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    static void setup(Graph graph){
        graph.addEdge("a", "b", 8);
        graph.addEdge("b", "c", 1);
        graph.addEdge("c", "f", 1);
        graph.addEdge("b", "f", 2);
        graph.addEdge("a", "d", 2);
        graph.addEdge("d", "b", 4);
        graph.addEdge("a", "e", 4);
        graph.addEdge("d", "e", 3);
        graph.addEdge("e", "f", 9);
        graph.addEdge("d", "f", 7);
    }

    private final Set<String> nodes;
    private final List<Edge> edges;

    public Graph(){
        this.nodes = new HashSet<>();
        this.edges = new ArrayList<>();
    }

    int size(){
        return nodes.size();
    }

    void addNode(String node){
        nodes.add(node);
    }
    void addEdge(String src, String dst, int weight){
        nodes.add(src);
        nodes.add(dst);
        if(!edges.contains(new Edge(src,dst,weight))){
            edges.add(new Edge(src, dst, weight));
        }
    }


    List<Edge> getEdges(){
        return edges.stream().sorted().collect(Collectors.toList());
    }

    List<Edge> getConnectedEdges(String node){
        return edges.stream().filter(edge -> edge.src.equals(node) || edge.dst.equals(node)).collect(Collectors.toList());
    }

    record Edge(String src, String dst, int weight) implements Comparable<Edge>{
        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(this.weight, edge.weight);
        }
    }
}
