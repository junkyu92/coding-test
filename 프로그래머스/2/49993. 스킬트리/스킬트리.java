import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        
        for(String skill_tree : skill_trees){
            q.clear();
            for(String s : skill.split("")){
                q.offer(s);
            }
            boolean flag = true;
            for(String s : skill_tree.split("")){
                if(q.contains(s)){
                    if(q.peek().equals(s)){
                        q.poll();
                    }else{
                        flag = false;
                        break;
                    }
                } 
            }
            if(flag) answer++;
        }
        return answer;
    }
}