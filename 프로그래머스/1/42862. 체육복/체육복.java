import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] student = new int[n+2];
        
        for(int i : lost){
            student[i]--;
        }
        for(int i : reserve){
            student[i]++;
        }
        for(int i = 1; i < student.length-1; i++){
            if(student[i]==-1 && student[i-1]==1) {
                student[i]++;
                student[i-1]--;
            } else if(student[i]==-1 && student[i+1]==1){
                student[i]++;
                student[i+1]--;
            }
        }
        return (int)Arrays.stream(student).filter(i->i>=0).count() - 2;
    }
} 
