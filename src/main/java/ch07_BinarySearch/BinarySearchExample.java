package ch07_BinarySearch;

public class BinarySearchExample {
    public static int BinarySearch(int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start+end)/2;
        if(arr[mid] == target){
            return mid;
        } else if (arr[mid] > target) {
            return BinarySearch(arr, target, start ,mid-1);
        }else{
            return BinarySearch(arr, target, mid+1, end);
        }
    }
}
