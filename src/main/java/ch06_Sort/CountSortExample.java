package ch06_Sort;

import java.util.Arrays;

public class CountSortExample {
    public static int[] CountSort(int[] arr){
        int[] sortedArr = new int[arr.length];
        int max = Arrays.stream(arr).max().getAsInt();
        int[] table = new int[max+1];
        for(int i:arr){
            table[i] += 1;
        }
        int idx = 0;
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[i];j++){
                sortedArr[idx++] = i;
            }
        }
        return sortedArr;
    }
}
