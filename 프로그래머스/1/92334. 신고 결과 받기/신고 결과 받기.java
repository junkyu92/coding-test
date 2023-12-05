import java.util.*;
class Solution {
    //report를 set에 담기 
    //
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        int[] answer = new int[id_list.length];
        for(String r : report){
            String[] tmp = r.split(" ");
            Set<String> s = map.getOrDefault(tmp[1], new HashSet<>());
            map.put(tmp[1], s);
            s.add(tmp[0]);
        }

        map.forEach((key,value) -> {
            if(value.size()>=k) {
                for(int i = 0; i < id_list.length; i++){
                    for(String s : value){
                        
                        if(id_list[i].equals(s)) answer[i]++;
                    }
                }
                    
            }
        });
        return answer;
    }
}