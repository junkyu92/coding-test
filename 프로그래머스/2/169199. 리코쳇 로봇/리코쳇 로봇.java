import java.util.*;
class Solution {
    //최단거리 - BFS?
    //100*100 = 10,000 -> 10,000 제곱해도 1억
    
    //상하좌우 방향으로 끝까지 
    //R: 시작점
    //G: 도착점
    //D: 장애물
    
    //G주위에 장애물 or 끝점이 있어야 하고 
    public int solution(String[] board) {
        String[][] map = new String[board.length][board[0].length()];
        boolean[][] visited = new boolean[board.length][board[0].length()];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] start = new int[2];
        int[] goal = new int[2];
        
        //전체 돌면서 이차원배열로 변경 & 시작점 끝점 좌표 저장
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                String[] temp = board[i].split("");
                map[i][j] = temp[j];
                
                //시작점 방문체크, 횟수0으로 초기화
                if(temp[j].equals("R")){
                    visited[i][j] = true;
                    start[0] = i;
                    start[1] = j;
                    map[i][j] = "0";
                }
                
                if(temp[j].equals("G")){
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        //큐에 좌표배열 저장
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int[] xy = q.poll();
            for(int i = 0; i < dx.length; i++){
                
                int nx = xy[0];
                int ny = xy[1];

                //방향 끝까지 이동
                while(true){
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                    //막히면 한칸 이전으로 돌리고 스톱
                    if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length() || map[nx][ny].equals("D")){
                        nx = nx - dx[i];
                        ny = ny - dy[i];
                        break;
                    }
                }

                //방문하지 않은 노드면
                //몇번째 이동인지 저장, 방문체크, 큐에 저장
                if(!visited[nx][ny]){
                    map[nx][ny] = String.valueOf(Integer.parseInt(map[xy[0]][xy[1]])+1);
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }

                //목표 도착시 도착점의 이동횟수 리턴
                if(nx==goal[0]&&ny==goal[1]){
                    return Integer.parseInt(map[nx][ny]);
                } 
                
            }
        }
        return -1;
    }
}