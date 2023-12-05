import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] keyPad = {{1,2,3},{4,5,6},{7,8,9},{10,0,10}};
        Map<Integer, int[]> map = new HashMap<>();
        map.put(1,new int[]{0,0});
        map.put(2,new int[]{0,1});
        map.put(3,new int[]{0,2});
        map.put(4,new int[]{1,0});
        map.put(5,new int[]{1,1});
        map.put(6,new int[]{1,2});
        map.put(7,new int[]{2,0});
        map.put(8,new int[]{2,1});
        map.put(9,new int[]{2,2});
        map.put(0,new int[]{3,1});
        int[] l = {3,0};
        int[] r = {3,2};
        StringBuilder sb = new StringBuilder();
        for(int number : numbers){
            int[] target = map.get(number);
            if(number==1 || number==4 || number==7){
                l = target;
                sb.append("L");
            }else if(number==3 || number==6 || number==9){
                r = target;
                sb.append("R");
            }else{
                int lMove = Math.abs(l[0]-target[0]) + Math.abs(l[1]-target[1]);
                int rMove = Math.abs(r[0]-target[0]) + Math.abs(r[1]-target[1]);
                if(lMove == rMove) {
                    if(hand.equals("right")) {
                        r = target;
                        sb.append("R");
                    }else{
                        l = target;
                        sb.append("L");
                    }
                }else if(lMove > rMove){
                    r = target;
                    sb.append("R");
                }else{
                    l = target;
                    sb.append("L");
                }
            }
        }
        return sb.toString();
    }
}