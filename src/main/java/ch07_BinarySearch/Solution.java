package ch07_BinarySearch;

import java.util.Arrays;

import static ch07_BinarySearch.BinarySearchExample.BinarySearch;

public class Solution {

    // Q1. 부품 찾기
    public String question01(int[] arr1, int[] arr2){
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr1);
        for(int i:arr2){
            if(BinarySearch(arr1, i, 0, arr1.length)!= -1){
                sb.append("yes ");
            }else{
                sb.append("no ");
            }
        }

        return sb.substring(0, sb.length()-1);
    }

    // Q2. 떡볶이 떡 만들기
    public int question02(int m, int[] arr){
        int answer = 0;
        int start = 0;
        int end = Arrays.stream(arr).max().getAsInt();
        while(start<=end){
            int total = 0;
            int mid = (start+end)/2;
            for(int i:arr){
                total += i > mid ? i-mid : 0;
            }
            if (total < m){
                end = mid -1;
            }else{
                answer = mid;
                start = mid+1;
            }
        }
        return answer;
    }
}
