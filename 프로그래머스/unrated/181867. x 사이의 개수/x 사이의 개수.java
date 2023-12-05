import java.util.*;
class Solution {
    public int[] solution(String myString) {
        int[] answer = Arrays.stream(myString.split("x", -1)).mapToInt(s -> s.length()).toArray();
        return answer;
    }
}