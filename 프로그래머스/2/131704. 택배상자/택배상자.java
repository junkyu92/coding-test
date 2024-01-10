import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int index = 0;
        
        while(order[0] != num){
            stack.push(num++);
        }
        
        while(index < order.length){
            if(order[index] == num) {
                num++;
                answer++;
                index++;
            }else if(!stack.isEmpty() && order[index] == stack.peek()) {
                stack.pop();
                answer++;
                index++;
            }else if(order[index] > num) stack.push(num++);
            else break;
        }
        
        return answer;
    }
}