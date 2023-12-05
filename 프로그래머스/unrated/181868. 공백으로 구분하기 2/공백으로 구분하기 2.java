import java.util.*;
class Solution {
    public String[] solution(String my_string) {
        String[] answer = my_string.split(" ");
        answer = Arrays.stream(answer).filter(s -> !s.equals("")).toArray(String[]::new);
        return answer;
    }
}