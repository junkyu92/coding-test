class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        int[] xList = new int[d/k + 1];
        for(int i = 0; i <= d/k; i++){
            xList[i] = k*i;
        }
        
        for(int i = 0; i < xList.length; i++){
            int maxY = (int)Math.sqrt(Math.pow(d,2) - Math.pow(xList[i],2));
            answer += maxY/k +1;
        }
        return answer;
    }
}