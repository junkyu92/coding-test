import java.util.*;
import java.util.stream.*;
class Solution {
    //올바른 괄호 문자열인지 판단하는 메서드
    //큐에 넣어서 x번 메서드 실행
    static int answer;
    public int solution(String s) {
        answer = 0;
        Queue<String> q = new LinkedList<>();
        for(String st : s.split("")){
            q.offer(st);
        }
        for(int i = 0; i < s.length(); i++){
            match(q.stream().collect(Collectors.joining()));
            q.offer(q.poll());
        }
        return answer;
    }
    
    public void match(String S){
        Stack<String> stack = new Stack<>();
        boolean can = true;
        for(String s : S.split("")){
            if(s.equals("(") || s.equals("[") || s.equals("{")){
                stack.push(s);
            }else{
                if(stack.isEmpty()) return;
                String pop = stack.pop();
                if(pop.equals("(") && !s.equals(")")) return;
                else if(pop.equals("[") && !s.equals("]")) return;
                else if(pop.equals("{") && !s.equals("}")) return;
            }
        }
        if(stack.isEmpty()) answer++;
    }
}