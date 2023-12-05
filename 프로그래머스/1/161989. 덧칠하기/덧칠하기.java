import java.util.*;
class Solution {
    
    //n미터 벽 페인트칠
    //롤러 길이 m
    //롤러 벽 밖으로 나가면 x
    //최소횟수
    //길이 n만큼 배열 생성
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int answer2 = 0;
        boolean[] wall = new boolean[n+1];
        for(int i : section){
            wall[i] = true;
        }
        for(int i = 1; i < n+1; i++){
            if(wall[i]==true) {
                answer++;
                for(int j = 1; j < m; j++){
                    if(i+j<n) wall[i+j] = false;
                }
            }
        }
        for(int i = n; i > 0; i--){
            if(wall[i]==true) {
                answer2++;
                for(int j = 1; j < m; j++){
                    if(i-j>0) wall[i-j] = false;
                }
            }
        }
        
        return Math.min(answer,answer2);
    }
}