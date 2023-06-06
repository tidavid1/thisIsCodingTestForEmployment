package ch04_Implementation;

public class Solution {
    // Q1. 상하좌우
    public String question01(int n, String moves){
        int[] location = new int[]{1,1};
        for(String s:moves.split(" ")){
            switch (s){
                case "U" -> location[0] = location[0] == 1 ? 1 : location[0]-1;
                case "D" -> location[0] = location[0] == n ? n : location[0]+1;
                case "L" -> location[1] = location[1] == 1 ? 1 : location[1]-1;
                default -> location[1] = location[1] == n ? n : location[1]+1;
            }
        }
        return location[0]+" "+location[1];
    }

    // Q2. 시각
    public int question02(int n){
        int answer = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<60;j++){
                for(int k=0;k<60;k++) {
                    if(Integer.toString(i).contains("3") ||Integer.toString(j).contains("3")||Integer.toString(k).contains("3"))
                        answer+=1;
                }
            }
        }
        return answer;
    }

    // Q3. 왕실의 나이트
    public int question03(String pos){
        int answer = 0;
        int x = pos.toCharArray()[0] - '`';
        int y = pos.toCharArray()[1]-'0';
        int[][] steps = {{-2, -1}, {-1, -2}, {1,-2}, {2,-1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
        for(int[] step:steps){
            if(1<=x+step[0] && x+step[0] <= 8 && 1<=y+step[1] && y+step[1] <= 8)
                answer += 1;
        }
        return answer;
    }

    // Q4. 게임 개발
    public int question04(String size, int[] player, int[][]map){
        int answer = 0;
        int xlim = Integer.parseInt(size.split(" ")[0]);
        int ylim = Integer.parseInt(size.split(" ")[1]);
        int[][] moved = new int[xlim][ylim];
        int x = player[0];
        int y = player[1];
        int direction = player[2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int turns = 0;
        while(true){
            direction = direction == 0 ? 3: direction-1;
            int nx = x+dx[direction] < 0 ? 0 : Math.min(x + dx[direction], xlim - 1);
            int ny = y+dy[direction] < 0 ? 0 : Math.min(y + dy[direction], ylim - 1);
            if(moved[nx][ny] == 0 && map[nx][ny]==0){
                x = nx;
                y = ny;
                moved[x][y] = 1;
                answer += 1;
                turns = 0;
                continue;
            } else{
                turns += 1;
            }
            if(turns == 4){
                nx = x-dx[direction] < 0 ? 0 : Math.min(x-dx[direction] ,xlim-1);
                ny = y-dy[direction] < 0 ? 0 : Math.min(y-dy[direction], ylim-1);
                if(map[nx][ny] == 0){
                    x = nx;
                    y = ny;
                }else break;
                turns = 0;
            }
        }
        return answer;
    }
}
