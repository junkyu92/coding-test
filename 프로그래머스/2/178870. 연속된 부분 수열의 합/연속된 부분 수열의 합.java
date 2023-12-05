class Solution {
    //sIdx eIdx 한칸씩 옮기면서 체크
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,1000001};
        int sIdx = 0;
        int eIdx = 0;
        int now = 0;
        
        //sequence합 <= k -> eIdx++
        //sequence합 > k -> sIdx++
        //sequence합 = k -> 저장
        
        while(true){
            if(now <= k && eIdx < sequence.length){
                now = now + sequence[eIdx];
                eIdx++;
            }else{
                now = now - sequence[sIdx];
                sIdx++;
                if(sIdx == eIdx) break;
            }
            
            if(now == k){
                if(answer[1] - answer[0] > eIdx-1 - sIdx){
                    answer[0] = sIdx;
                    answer[1] = eIdx-1;
                }
            }
        }
        
        return answer;
    }
}