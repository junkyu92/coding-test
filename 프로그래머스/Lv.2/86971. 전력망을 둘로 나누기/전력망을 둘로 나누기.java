import java.util.*;
class Solution {
    int[][] w;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        w = wires;
        for(int i = 0; i < wires.length; i++){
            visited = new boolean[n+1];
            int[] cut = wires[i];
            visited[cut[0]] = true;
            visited[cut[1]] = true;
            answer = Math.min(answer, Math.abs(bfs(cut[0]) - bfs(cut[1])));
        }
        return answer;
    }
    public int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        int count = 1;
        q.offer(start);
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i = 0; i < w.length; i++){
                int[] wire = w[i];
                if(wire[0] == num && !visited[wire[1]]) {
                    q.offer(wire[1]);
                    visited[wire[1]] = true;
                    count++;
                }else if(wire[1] == num && !visited[wire[0]]) {
                    q.offer(wire[0]);
                    visited[wire[0]] = true;
                    count++;
                }
            }
        }
        return count;
    }
}