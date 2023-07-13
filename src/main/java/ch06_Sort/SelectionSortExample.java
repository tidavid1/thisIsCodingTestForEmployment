package ch06_Sort;

public class SelectionSortExample {
    public static int[] SelectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int idx = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[idx]){
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }
}
