import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        for(int i : arr){
            for(int j : delete_list){
                if(i==j) list.add(i);
            }
        }

        return IntStream.range(0,arr.length).map(i -> arr[i]).filter(i -> !list.contains(i)).toArray();
    }
}