package ch06_Sort;


public class ShellSortExample {
    private final static int[] gaps = {1,4,10,23,57,132,301,701,1750};
    public static int[] ShellSort(int[] arr){
        int idx = getGap(arr.length);
        while(idx >= 0){
            int step = gaps[idx--];
            for(int i=step;i<arr.length;i++){
                for(int j=i;j>=step && arr[j] < arr[j-step];j -= step){
                    swap(arr, j, j-step);
                }
            }
        }

        return arr;
    }

    private static int getGap(int n){
        int idx = 0;
        int len = (int) (n/2.25);
        while(gaps[idx] < len){
            idx+=1;
        }
        return idx;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
