import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] numbers) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        for(int i = 0; i < numbers.length; i++){
            int num = numbers[i];
            
            while(!pq.isEmpty() && pq.peek()[1] < num){
                numbers[pq.poll()[0]] = num;
            }
            
            pq.offer(new int[] {i, num});
        }
        
        while(!pq.isEmpty()){
            numbers[pq.poll()[0]] = -1;
        }
        return numbers;
    }
}