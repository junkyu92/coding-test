import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        //스택풀이
        Stack<Price> stack = new Stack<>();
        for(int i = 0; i < prices.length; i++){
            answer[i] = prices.length - i - 1;
            Price price = new Price(prices[i], i);
            if(stack.isEmpty()) stack.push(price);
            else{
                while(!stack.isEmpty() && stack.peek().price > prices[i]){
                    answer[stack.peek().idx] = i - stack.pop().idx;
                }
                stack.push(price);
            }
        }
        return answer;
    }
}

class Price{
    int price;
    int idx;
    
    Price(int price, int idx){
        this.price = price;
        this.idx = idx;
    }
}