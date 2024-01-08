import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i : map.values().stream().sorted((o1,o2) -> o2-o1).mapToInt(i -> i).toArray()){
            answer++;
            k -= i;
            if(k<=0) break;
        }
        return answer;
    }
}
