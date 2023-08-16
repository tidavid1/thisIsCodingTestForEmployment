package ch10_GrpahTheory;

import java.util.Arrays;

public class UnionExample {
    public static int[] unionExample(int node, int edge, int[][] unions){
        int[] parents = new int[node+1];
        Arrays.setAll(parents, i -> i);
        for(int[] union:unions){
            union_parent(parents, union[0], union[1]);
        }
        for(int i=1;i<parents.length;i++){
            find_parent(parents, i);
        }
        return parents;
    }

    static int find_parent(int[] parents, int x){
        if(parents[x] != x){
            parents[x] = find_parent(parents, parents[x]);
        }
        return parents[x];
    }

    static void union_parent(int[] parents, int a, int b){
        a = find_parent(parents, a);
        b = find_parent(parents, b);
        if (a<b){
            parents[b] = a;
        }else{
            parents[a] = b;
        }
    }
}
