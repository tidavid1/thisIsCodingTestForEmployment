package ch06_Sort;

import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSortExample {
    public static int[] HeapSort(int[] arr){
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i:arr){
            queue.offer(i);
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = queue.poll();
        }
        return arr;
    }
}
