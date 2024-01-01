import java.util.*;
class Solution {
    //S -> L -> E 최단거리
    //bfs
    boolean[][] visited;
    String[][] mapsArr;
    int answer;
    public int solution(String[] maps) {
        answer = 0;
        visited = new boolean[maps.length][maps[0].length()];
        int[] S = new int[2];
        int[] L = new int[2];
        int[] E = new int[2];
        mapsArr = new String[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            String[] arr = maps[i].split("");
            for(int j = 0; j < arr.length; j++){
                mapsArr[i][j] = arr[j];
                if(arr[j].equals("S")) {
                    S[0] = i; 
                    S[1] = j;
                }
                else if(arr[j].equals("L")) {
                    L[0] = i; 
                    L[1] = j;
                }
                else if(arr[j].equals("E")) {
                    E[0] = i; 
                    E[1] = j;
                }
            }
        }
        bfs(S,L);
        if(visited[L[0]][L[1]]) bfs(L,E);
        else return -1;
        return visited[E[0]][E[1]] ? answer : -1;
    }
    
    public void bfs(int[] start, int[] end){
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[mapsArr.length][mapsArr[0].length];
        visited[start[0]][start[1]] = true;
        q.offer(new Node(start[0], start[1], 0));
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i = 0; i < dx.length; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < mapsArr.length && ny < mapsArr[0].length && !visited[nx][ny] && !mapsArr[nx][ny].equals("X")){
                    visited[nx][ny] = true;
                    if(nx == end[0] && ny == end[1]){
                        answer += now.d+1;
                        return;
                    }
                    q.offer(new Node(nx, ny, now.d+1));
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int d;
    Node(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}