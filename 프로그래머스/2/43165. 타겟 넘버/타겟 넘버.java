class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int sum, int idx){
        for(int i = 0; i < 2; i++){
            int tempSum = sum;
            
            if(i==0) tempSum += numbers[idx];
            else tempSum -= numbers[idx];

            if(idx < numbers.length-1){
                dfs(numbers, target, tempSum, idx+1);
            }else if(tempSum == target){
                answer++;
            }
        }
    }
}
