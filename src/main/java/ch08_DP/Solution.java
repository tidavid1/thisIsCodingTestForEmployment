package ch08_DP;

public class Solution {

    // Q1. 1로 만들기
    public int question01(int n){
        int[] table = new int[30001];
        for (int i = 2; i <= n; i++) {
            table[i] = table[i-1]+1;
            if(i%2==0){
                table[i] = Math.min(table[i], table[i/2]+1);
            }
            if(i%3 == 0){
                table[i] = Math.min(table[i], table[i/3]+1);
            }
            if(i%5 == 0){
                table[i] = Math.min(table[i], table[i/5]+1);
            }
        }
        return table[n];
    }

    // Q2. 개미 전사
    public int question02(int n, int[] arr){
        int[] table = new int[n];
        table[0] = arr[0];
        table[1] = Math.max(arr[0], arr[1]);
        for(int i=2;i<n;i++){
            table[i] = Math.max(table[i-1], table[i-2]+arr[i]);
        }
        return table[n-1];
    }

    // Q3. 바닥 공사
    public int question03(int n){
        int[] table = new int[n+1];
        table[1] = 1; table[2] = 3;
        for(int i=3;i<=n;i++){
            table[i] = (table[i-1]+2 * table[i-2])%796796;
        }
        return table[n];
    }

    // Q4. 효율적인 화폐 구성
    public int question04(int[] coins, int n){
        int[] table = new int[n+1];
        for(int i=1;i<table.length;i++){
            table[i] = Integer.MAX_VALUE;
        }
        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                table[j] = table[j - coin] != Integer.MAX_VALUE ? Math.min(table[j], table[j - coin] + 1) : table[j];
            }
        }
        return table[n] == Integer.MAX_VALUE ? -1 : table[n];
    }
}
