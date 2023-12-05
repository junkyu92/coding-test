import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] newRank = new int[rank.length];
        
        Map<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]) {
                map.put(rank[i],i);
                pq.offer(rank[i]);
            }
        }
        
        answer = map.get(pq.poll())*10000 + map.get(pq.poll())*100 + map.get(pq.poll());
            
        return answer;
    }
}