import java.util.*;
class Solution {
    //사진별 추억점수 = 인물의 그리움점수 합산
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        for(int i = 0; i < photo.length; i++){
            for(String p : photo[i]){
                answer[i] = answer[i] + map.getOrDefault(p,0);
            }
        }
        
        return answer;
    }
}