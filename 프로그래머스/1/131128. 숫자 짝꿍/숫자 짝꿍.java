import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "-1";
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
        StringBuilder sb = new StringBuilder();
        for(String x : X.split("")){
            map.put(Integer.parseInt(x), map.getOrDefault(Integer.parseInt(x),0) + 1);
        }
        
        for(String y : Y.split("")){
            if(map.getOrDefault(Integer.parseInt(y),0)>0){
                pq.offer(Integer.parseInt(y));
                map.put(Integer.parseInt(y), map.get(Integer.parseInt(y)) - 1);
            }
        }
        
        if(pq.isEmpty()) sb.append(-1);
        else if(pq.peek()==0) sb.append(0);
        else{
            while(!pq.isEmpty()){
                sb.append(pq.poll());
            }
        }

        answer = sb.toString();
        
        return answer;
    }
}