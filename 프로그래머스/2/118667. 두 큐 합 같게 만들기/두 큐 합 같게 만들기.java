import java.util.*;
class Solution {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long q1Sum = 0;
        long q2Sum = 0;
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        
        for(int i : queue1) {
            q1.offer(i);
            q1Sum += i;
        }
        for(int i : queue2) {
            q2.offer(i);
            q2Sum += i;
        }
        
        while(q1Sum != q2Sum){
            answer++;
            if(q1Sum > q2Sum){
                int num = q1.poll();
                q1Sum -= num;
                q2Sum += num;
                q2.offer(num);
            }else if(q1Sum < q2Sum){
                int num = q2.poll();
                q2Sum -= num;
                q1Sum += num;
                q1.offer(num);
            }
            if(answer > (q1.size()+q2.size())*2) return -1;
        }
        
        return answer;
    }
}