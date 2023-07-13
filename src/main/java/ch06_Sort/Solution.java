package ch06_Sort;

import java.util.*;

public class Solution {

    // Q1. 위에서 아래
    public int[] question01(int n, String numbers){
        int[] answer = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(answer);
        return answer;
    }

    // Q2. 성적이 낮은 순서로 학생 출력하기
    public String[] question02(int n, String values){
        String[] answer = new String[n];
        Map<Integer, List<String>> table = new HashMap<>();
        for(String s:values.split("\\n")){
            int score = Integer.parseInt(s.split(" ")[1]);
            List<String> temp = table.getOrDefault(score, new ArrayList<>());
            temp.add(s.split(" ")[0]);
            table.put(score, temp);
        }
        int idx = 0;
        for(int i:table.keySet().stream().sorted(Comparator.reverseOrder()).toList()){
            for(String s: table.get(i)){
                answer[idx++] = s;
            }
        }
        return answer;
    }

    // Q3. 두 배열의 원소 교체
    public int question03(int n, int k, int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] temp = arr2.clone();
        for(int i=n-1, j=0;i>=0;i--,j++){
            arr2[i] = temp[j];
        }
        for(int i=0;i<k;i++){
            if(arr1[i] < arr2[i]){
                int t = arr1[i];
                arr1[i] = arr2[i];
                arr2[i] = t;
            }else{
                break;
            }
        }
        return Arrays.stream(arr1).sum();
    }
}
