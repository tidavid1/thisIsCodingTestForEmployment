package ch06_Sort;

public class InsertionSortExample {
    public static int[] InsertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int currentElement = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]> currentElement){
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = currentElement;
        }
        return arr;
    }
}
