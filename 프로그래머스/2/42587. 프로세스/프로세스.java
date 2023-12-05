import java.util.*;
class Solution {
    
    public int solution(int[] priorities, int location) {
        int[] count = new int[10];
        int maxP = 0;
        Queue<Integer> q = new LinkedList<>();
        int answer = 0;
        //큐에 넣기 
        //숫자 갯수 저장
        //우선순위 가장 큰 수 maxP
        for(int i : priorities) {
            count[i]++; 
            q.offer(i);
            maxP = Math.max(maxP,i);
        }
        //원하는 위치의 수 나올때까지 반복
        while(true){
            //일단 뽑음
            int poll = q.poll();
            //뽑은 수보다 우선순위 높은 숫자가 존재하면 다시 넣기
            if(poll<maxP){
                q.offer(poll);
            }else{
                //뽑은 횟수 +1
                answer++;
                //location이 0이면 종료
                if(location==0) break;
                //뽑으면 우선순위 제일 높은 숫자 갯수 -1
                count[maxP]--;
                //0이면 다음 우선순위 높은 숫자까지 -1
                if(count[maxP]==0) {
                    while(count[maxP]==0){
                        maxP--;
                    }
                }
            }
            //한번 뽑을때마다 location이동 
            //뽑았을 때 0이면 원하는 숫자
            if(location==0) location = q.size()-1;
            else location--;
        }
        
        return answer;
    }
}