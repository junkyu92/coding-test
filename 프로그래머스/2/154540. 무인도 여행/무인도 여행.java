import java.util.*;
class Solution {
    //지도 X=바다 숫자=무인도
    //bfs
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        int[][] mapArr = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                String c = maps[i].substring(j,j+1);
                if(c.equals("X")) mapArr[i][j] = 0;
                else mapArr[i][j] = Integer.parseInt(c);
            }
        }
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                //시작점 설정
                if(!visited[i][j] && mapArr[i][j]!=0){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    //bfs(q, );
                    int total = 0;
                    while(!q.isEmpty()){
                        int[] xy = q.poll();
                        int x = xy[0];
                        int y = xy[1];
                        total += mapArr[x][y];
                        for(int k = 0; k < dx.length; k++){
                            boolean inMap = x+dx[k] >= 0 && y+dy[k] >= 0 && x+dx[k] < mapArr.length && y+dy[k] < mapArr[0].length;
                            if(inMap && !visited[x+dx[k]][y+dy[k]] && mapArr[x+dx[k]][y+dy[k]]!=0){
                                q.offer(new int[]{x+dx[k], y+dy[k]});
                                visited[x+dx[k]][y+dy[k]] = true;
                            }
                        }
                    }
                    list.add(total);
                }
            }
        }
        return list.isEmpty() ? new int[] {-1} : list.stream().sorted().mapToInt(x -> x).toArray();
    }
}