import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[][] arr = new int[wallpaper.length+1][wallpaper[0].length()+1];
        int[] answer = {50, 50, 0, 0};
        for(int i = 0; i < wallpaper.length; i++){
            String[] temp = wallpaper[i].split("");
            for(int j = 0; j < temp.length; j++){
                if(temp[j].equals("#")){
                    answer[0] = Math.min(answer[0],i);
                    answer[1] = Math.min(answer[1],j);
                    answer[2] = Math.max(answer[2],i+1);
                    answer[3] = Math.max(answer[3],j+1);
                }
            }
        }
        
        return answer;
    }
}