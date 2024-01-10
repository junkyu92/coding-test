import java.util.*;
class Solution {
    Map<String, Integer> wantMap;
    Map<String, Integer> discountMap;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        wantMap = new HashMap<>();
        discountMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int i = 0; i < 10; i++){
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        if(check()) answer++;
        
        for(int i = 10; i < discount.length; i++){
            discountMap.put(discount[i-10], discountMap.get(discount[i-10]) - 1);
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
            if(check()) answer++;
        }
        
        return answer;
    }
    
    public boolean check(){
        for(String key : wantMap.keySet()){
            if(wantMap.get(key) != discountMap.getOrDefault(key,-1)){
                return false;
            }
        }
        return true;
    }
}