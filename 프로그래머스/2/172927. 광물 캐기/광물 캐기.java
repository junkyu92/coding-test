import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int mins_num = Math.min(minerals.length, (picks[0]+picks[1]+picks[2]) * 5);
        int[][] arr = new int[mins_num/5 + 1][5];
        Queue<Pick> q = new LinkedList<>();
        
        for(int i = 0; i < mins_num; i++){
            if(minerals[i].equals("diamond")) arr[i/5][i%5] = 25;
            else if(minerals[i].equals("iron")) arr[i/5][i%5] = 5;
            else arr[i/5][i%5] = 1;
        }
        
        Arrays.sort(arr, (o1, o2) -> Arrays.stream(o2).sum() - Arrays.stream(o1).sum());
        
        for(int i = 0; i < arr.length; i++){
            if(picks[0]-- > 0) q.offer(new DiaPick());
            else if(picks[1]-- > 0) q.offer(new IronPick());
            else if(picks[2]-- > 0) q.offer(new StonePick());
        }
        
        Pick pick = q.poll();
        for(int i = 0; i < mins_num; i++){
            if(pick.count<1) pick = q.poll();
            if(arr[i/5][i%5]!=0) answer += pick.use(arr[i/5][i%5]);
            else {
                pick.count--;
                mins_num++;
            }
        }
        return answer;
    }
}

class Pick {
    int power;
    int count = 5;
    
    public int use(int mineral){
        count--;
        return Math.max(1, mineral / power);
    }
}

class DiaPick extends Pick {
    DiaPick(){
        power = 25;
    }
}

class IronPick extends Pick {
    IronPick(){
        power = 5;
    }
}

class StonePick extends Pick {
    StonePick(){
        power = 1;
    }
}