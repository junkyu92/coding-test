import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //첫번째 작업이 배포될 때 뒤에 연결돼서 완료된 작업들 같이 배포  
        Queue<Progress> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        //큐에 Progress저장
        for(int i = 0; i < progresses.length; i++){
            q.offer(new Progress(progresses[i], speeds[i]));
        }
        
        while(!q.isEmpty()){
            int count = 0;
            
            //하루치 작업 진행
            q.stream().forEach(Progress::dayWork);
            
            //앞에서부터 완료된 개수 카운트
            while(!q.isEmpty() && q.peek().percent>=100){
                q.poll();
                count++;
            }
            
            //완료 개수 저장
            if(count!=0) answer.add(count);
            
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}

class Progress {
    int percent;
    int speed;
    
    Progress(int percent, int speed){
        this.percent = percent;
        this.speed = speed;
    }
    
    public void dayWork(){
        percent += speed;
    }
}