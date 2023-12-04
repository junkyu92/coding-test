import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack;
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                stack = map.getOrDefault(board.length-j, new Stack<>());
                if(board[board.length-1-i][board.length-1-j] != 0){
                    stack.push(board[board.length-1-i][board.length-1-j]);
                }
                map.put(board.length-j, stack);
            }
        }
        
        stack = new Stack<>();
        
        for(int i : moves){
            Stack<Integer> getStack = map.get(i);
            if(!getStack.isEmpty()){
                int pop = getStack.pop();
                int tmp = 31;
                if(!stack.isEmpty()) {
                    tmp = stack.peek();
                }
                if(tmp==pop) {
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(pop);
                }
            }
        }
        
        return answer;
    }
}