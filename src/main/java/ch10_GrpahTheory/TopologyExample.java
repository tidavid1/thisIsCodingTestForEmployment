package ch10_GrpahTheory;

import java.util.*;
import java.util.stream.Collectors;

public class TopologyExample {

    static void setup(Graph graph){
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 6);
        graph.addEdge(3, 4);
        graph.addEdge(4, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
    }

    static int[] topologySort(Graph graph){
        int[] inDegree = new int[graph.size()+1];
        for(Graph.Edge edge: graph.getEdges()){
            inDegree[edge.dst()] +=1;
        }
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            result.add(now);
            for(Graph.Edge edge: graph.getEdgesBySrc(now)){
                inDegree[edge.dst()] -= 1;
                if (inDegree[edge.dst()] == 0){
                    queue.add(edge.dst());
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static class Graph{
        private final Set<Integer> nodes;
        private final List<Edge> edges;

        public Graph(){
            nodes = new HashSet<>();
            edges = new ArrayList<>();
        }

        void addEdge(int src, int dst){
            nodes.add(src);
            nodes.add(dst);
            if(!edges.contains(new Edge(src, dst))){
                edges.add(new Edge(src,dst));
            }
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public List<Edge> getEdgesBySrc(int src){
            return edges.stream().filter(edge -> edge.src == src).collect(Collectors.toList());
        }

        int size(){
            return nodes.size();
        }

        record Edge(int src, int dst){}
    }
}
