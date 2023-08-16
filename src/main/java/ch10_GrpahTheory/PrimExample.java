package ch10_GrpahTheory;


import java.util.*;

public class PrimExample {
    static int primExample(Graph graph, String node){
        int cost = 0;
        Graph prim = new Graph();
        Map<String ,Integer> weights = new HashMap<>();
        weights.put(node, 0);
        for (Graph.Edge edge: graph.getConnectedEdges(node)){
            if(edge.src().equals(node)){
                weights.put(edge.dst(), edge.weight());
            }else{
                weights.put(edge.src(), edge.weight());
            }
        }
        prim.addNode(node);
        while(prim.size()< graph.size()){
            int min = Integer.MAX_VALUE;
            for(String key:weights.keySet()){
                if(weights.get(key) < min && weights.get(key) != 0) {
                    min = weights.get(key);
                    node = key;
                }
            }
            cost += min;
            prim.addNode(node);
            weights.put(node, 0);
            for (Graph.Edge edge: graph.getConnectedEdges(node)){
                if(edge.src().equals(node)){
                    weights.put(edge.dst(), Math.min(weights.getOrDefault(edge.dst(), Integer.MAX_VALUE),edge.weight()));
                }else{
                    weights.put(edge.src(), Math.min(weights.getOrDefault(edge.src(), Integer.MAX_VALUE),edge.weight()));
                }
            }
        }
        return cost;
    }
}
