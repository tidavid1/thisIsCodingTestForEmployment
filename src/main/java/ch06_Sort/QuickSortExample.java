package ch06_Sort;

public class QuickSortExample {
    public static int[] QuickSort(int[] arr, int start, int end){
        if(start >= end){
            return arr;
        }
        int left = start+1;
        int right = end;
        while(left <= right){
            while(left <= end && arr[left] <= arr[start]){
                left += 1;
            }
            while(right > start && arr[right] >= arr[start]){
                right -= 1;
            }
            if(left>right){
                swap(arr, right, start);
            }else{
                swap(arr,left,right);
            }
        }
        QuickSort(arr, start, right-1);
        QuickSort(arr,right+1, end);
        return arr;
    }

    private static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
