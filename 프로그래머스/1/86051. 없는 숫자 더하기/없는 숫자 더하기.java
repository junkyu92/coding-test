class Solution {
    public int solution(int[] numbers) {
        boolean[] hasNum = new boolean[10];
        int answer = 0;
        
        for(int number : numbers){
            hasNum[number] = true;
        }
        
        for(int i = 0; i < hasNum.length; i++){
            if(!hasNum[i]) answer += i;
        }
        
        return answer;
    }
}