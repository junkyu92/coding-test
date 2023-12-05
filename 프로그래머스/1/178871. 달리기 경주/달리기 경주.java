import java.util.*;
class Solution {
    //이중 배열 시간복잡도 500억 X
    //해시 이름 : 순위 저장 
    //callings 반복문 -> 이름 검색 후 순위 -1, 앞 사람 +1
    //앞사람 +1 하는 부분 ??

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            map.put(players[i],i);
        }
        
        for(int i = 0; i < callings.length; i++){
            int now = map.get(callings[i]);
            String temp = players[now];
            players[now] = players[now-1];
            players[now-1] = temp;
            
            map.put(players[now], now);
            map.put(players[now-1], now-1);
        }
        
        return players;
    }

}