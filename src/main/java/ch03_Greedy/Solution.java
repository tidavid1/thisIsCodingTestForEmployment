package ch03_Greedy;

import java.util.Arrays;

public class Solution {
    // 예제 3-1 거스름돈
    public int question01(int money){
        int answer = 0;
        int[] coins = new int[]{500,100,50,10};
        for(int coin:coins){
            answer += money/coin;
            money %= coin;
        }
        return answer;
    }

    // 3-2 큰 수의 법칙
    public int question02(int n, int m, int k, int[] arr){
        int answer = 0;
        Arrays.sort(arr);
        for(int i=1;i<=m;i++){
            answer += arr[i%k==0?n-2:n-1];
        }
        return answer;
    }

    // 3-3 숫자 카드 게임
    public int question03(int n, int m, int[][] cards){
        int answer = 0;
        for(int i=0;i<n;i++){
            Arrays.sort(cards[i]);
            if(cards[i][0] > answer) answer = cards[i][0];
        }
        return answer;
    }

    // 3-4 1이 될 때까지
    public int question04(int n, int k){
        int answer = 0;
        while(n>1){
            if(n%k==0) n/=k;
            else n-=1;
            answer+=1;
        }
        return answer;
    }
}
