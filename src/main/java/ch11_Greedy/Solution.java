package ch11_Greedy;

import java.util.*;
import java.util.stream.Stream;


public class Solution {
    // Q1. 모험가 길드
    public int question01(int[] arr){
        int count = 0;
        int result = 0;
        Arrays.sort(arr);
        for(int i:arr){
            count += 1;
            if(count >= i){
                result +=1;
                count=0;
            }
        }
        return result;
    }

    // Q2. 곱하기 혹은 더하기
    public int question02(String numbers){
        int result = 0;
        for(int i: Stream.of(numbers.split("")).mapToInt(Integer::parseInt).toArray()){
            result = result==0?result+i:i==0?result+i:result*i;
        }
        return result;
    }

    // Q3. 문자열 뒤집기
    public int question03(String s){
        int[] temp = new int[2];
        s = s.replaceAll("0+", "a").replaceAll("1+", "b");
        for(char c:s.toCharArray()){
            if(c == 'a') temp[0]+=1;
            else temp[1] += 1;
        }
        return Math.min(temp[0], temp[1]);
    }

    // Q4. 만들 수 없는 금액
    public int question04(int n, int[] coins){
        int result = 1;
        Arrays.sort(coins);
        for(int coin:coins){
            if (result < coin) break;
            result += coin;
        }
        return result;
    }

    // Q5. 볼링공 고르기
    public int question05(int n, int m, int[] balls){
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(balls[i]==balls[j]) continue;
                result+=1;
            }
        }
        return result;
    }

    // Q6. 무지의 먹방 라이브
    public int question06(int[] food_times, long k) {
        class Food {
            final int num;
            final int time;

            public Food(int num, int time) {
                this.num = num;
                this.time = time;
            }
        }
        LinkedList<Food> list = new LinkedList<>();
        int len = food_times.length;
        for(int i = 0; i < len; i++) {
            list.add(new Food(i + 1, food_times[i]));
        }
        list.sort(Comparator.comparingInt(o -> o.time));

        int current_time = 0;
        int idx = 0;
        for(Food f : list) {
            long diff = f.time - current_time;
            if(diff != 0) {
                long spend = diff * len;
                if(spend <= k) {
                    k -= spend;
                    current_time = f.time;
                } else {
                    k %= len;
                    list.subList(idx, food_times.length).sort(Comparator.comparingInt(o -> o.num));
                    return list.get(idx + (int)k).num;
                }
            }
            idx++;
            len--;
        }
        return -1;
    }
}
