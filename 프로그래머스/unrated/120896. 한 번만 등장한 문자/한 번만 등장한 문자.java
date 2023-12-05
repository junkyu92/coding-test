import java.util.*;
import java.util.stream.*;
class Solution {
    String answer;
    public String solution(String s) {
        answer = "";
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < s.length(); i++){
            String character = s.substring(i,i+1);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        map.forEach((k,v) -> {
            if(v==1) answer = answer + k;
        });
        return Arrays.stream(answer.split("")).sorted().collect(Collectors.joining());
    }
}