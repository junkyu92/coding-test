class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        //100,000 제곱 = 10,000,000,000 100초 X
        
        //두번째 탐색범위 줄어드는거 감안해도 
        //100,000 ~ 1 더하기
        //100,000 * 100,001 / 2 = 5,000,050,000 50초?
        
        //break 때문에 통과되는 것 같은데 
        //시간복잡도 최악으로 계산하면 50초라 실패해야되지 않나
        for(int i = 0; i < prices.length; i++){
            int target = prices[i];
            for(int j = i+1; j < prices.length; j++){
                answer[i]++;
                if(prices[j] < target) break;
            }
        }
        return answer;
    }
}