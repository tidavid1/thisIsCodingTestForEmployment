package ch05_DFSBFS;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // Q1. 음료수 얼려 먹기
    public int question01(int n, int m, String board){
        int answer = 0;
        int[][] table = new int[n][m];
        String[] temp = board.split("\\n");
        for(int i=0;i<n;i++){
            int j =0;
            for(String s:temp[i].split("")){
                table[i][j++] = Integer.parseInt(s);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(table[i][j] == 0){
                    DFS(i, j,n,m,table);
                    answer +=1;
                }
            }
        }
        return answer;
    }

    private void DFS(int i, int j, int n, int m, int[][] table) {
        table[i][j] = 1;
        int[][] targets = new int[][]{{i, j==0?j:j-1},{i, j==m-1?j:j+1}, {i==0?i:i-1, j}, {i==n-1?i:i+1, j}};
        for(int[] target :targets){
            if(table[target[0]][target[1]] == 0){
                DFS(target[0], target[1], n, m, table);
            }
        }
    }

    //  Q2. 미로 탈출
    public int question02(int n, int m, String board){
        int[][] table = new int[n][m];
        String[] temp = board.split("\\n");
        for(int i=0;i<n;i++){
            int j =0;
            for(String s:temp[i].split("")){
                table[i][j++] = Integer.parseInt(s);
            }
        }
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(0,0));
        while(!queue.isEmpty()){
            Location location = queue.poll();
            int x = location.getX();
            int y = location.getY();
            int[][] targets = new int[][]{{x, y==0?y:y-1}, {x, y==m-1?y:y+1}, {x==0?x:x-1, y}, {x==n-1?x:x+1, y}};
            for(int[] target:targets){
                if(table[target[0]][target[1]] == 0 || (target[0] == x && target[1] == y)){
                    continue;
                }
                if(table[target[0]][target[1]] == 1){
                    table[target[0]][target[1]] = table[x][y]+1;
                    queue.add(new Location(target[0], target[1]));
                }
            }
        }
        return table[n-1][m-1];
    }

    class Location{
        private int x;
        private int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }


}
