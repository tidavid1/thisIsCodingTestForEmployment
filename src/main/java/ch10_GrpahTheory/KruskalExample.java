package ch10_GrpahTheory;

import java.util.*;

public class KruskalExample {

    static int kruskalExample(Graph graph){
        int cost = 0;
        Graph kruskal = new Graph();
        List<Graph.Edge> edges = graph.getEdges();
        while(kruskal.getEdges().size() < graph.size()-1){
            Graph.Edge e = edges.remove(0);
            if(!isCycle(kruskal, e ,graph.size())){
                kruskal.addEdge(e.src(), e.dst(),e.weight());
                cost += e.weight();
            }
        }
        return cost == 0 ? -1 : cost;
    }
    static boolean isCycle(Graph graph, Graph.Edge edge, int size){
        int[] parents = new int[size+1];
        Arrays.setAll(parents, i -> i);
        for(Graph.Edge e:graph.getEdges()){
            union_parent(parents, e.src(), e.dst());
        }
        for (int i = 1; i < parents.length; i++) {
            find_parent(parents,i);
        }
        return find_parent(parents, edge.src().charAt(0) - 96) == find_parent(parents, edge.dst().charAt(0) - 96);
    }

    static void union_parent(int[] parents, String src, String dst){
        int x = find_parent(parents, src.charAt(0)-96);
        int y = find_parent(parents, dst.charAt(0)-96);
        if(x<y){
            parents[y] = x;
        }else{
            parents[x] = y;
        }
    }

    static int find_parent(int[] parents, int x){
        if(parents[x] != x){
            parents[x] = find_parent(parents, parents[x]);
        }
        return parents[x];
    }
}
