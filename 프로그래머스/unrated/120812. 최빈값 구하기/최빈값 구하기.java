import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        //1. 배열 1000개 만들어서 횟수 저장 후 반복문으로 최고값 획득 반복문으로 최고값과 같은 값 개수 확인
        //2. map에 <숫자, 횟수> 저장 후 반복문으로 최고값 획득 반복문으로 최고값과 같은 값 개수 확인
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < array.length; i++){
            if(map.get(array[i])==null)map.put(array[i], 1);
            else map.put(array[i], map.get(array[i]) + 1);
        }
        int max = 0;
        for(int key : map.keySet()){
            if(map.get(key)>max) max = map.get(key);
        }
        int maxCount = 0;
        for(int key : map.keySet()){
            if(map.get(key)==max){
                maxCount++;
            answer = key;
            }
        }
        if(maxCount>1){
            answer = -1;
        }
        return answer;
    }
}