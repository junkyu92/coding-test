import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : participant) map.put(s, map.getOrDefault(s,0)+1);
        for(String s : completion) map.put(s, map.get(s)-1);
        return map.entrySet().stream().filter(e -> e.getValue()==1).map(e -> e.getKey()).collect(Collectors.joining());
    }
}