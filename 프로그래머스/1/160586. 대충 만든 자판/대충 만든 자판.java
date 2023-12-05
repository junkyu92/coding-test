import java.util.*;
class Solution {
    //키 개수 1~100
    //최소 버튼 눌러야하는 횟수 
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> map = new HashMap<>();
        for(String key : keymap){
            for(int i = 0; i < key.length(); i++){
                String character = key.substring(i,i+1);
                if(map.getOrDefault(character,100)>i+1) map.put(character, i+1);
            }
        }
        
        for(int i = 0; i < targets.length; i++){
            for(int j = 0; j < targets[i].length(); j++){
                int num = map.getOrDefault(targets[i].substring(j,j+1),0);
                if(num > 0) {
                    answer[i] = answer[i] + num;
                }else{
                    answer[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}