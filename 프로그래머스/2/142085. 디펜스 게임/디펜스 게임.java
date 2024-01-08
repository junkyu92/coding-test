import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if(k >= enemy.length) return enemy.length;
        
        for(int i = 0; i < k; i++){
            pq.offer(enemy[i]);
            answer++;
        }
        
        for(int i = pq.size(); i < enemy.length; i++){
            if(pq.peek()<enemy[i] && pq.peek() <= n) {
                n -= pq.poll();
                pq.offer(enemy[i]);
                answer++;
            }else if(n >= enemy[i]){
                n -= enemy[i];
                answer++;
            }else break;
        }
        return answer;
    }
}