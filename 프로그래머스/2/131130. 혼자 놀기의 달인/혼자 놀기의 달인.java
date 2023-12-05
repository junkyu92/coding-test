import java.util.*;
class Solution {
    //최대 길이 100 - 시간복잡도 X
    static boolean[] visited;
    static List<Integer> list;
    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        list = new ArrayList<>();
        
        for(int i = 0; i < cards.length; i++){
            if(!visited[i]) dfs(cards, 0, i);
        }
        
        if(list.size()<2) return 0;
        
        return list.stream()
            .sorted(Comparator.reverseOrder())
            .limit(2)
            .reduce(1, (a, b) -> a * b);
    }
    
    public void dfs(int[] cards, int count, int idx){
        visited[idx] = true;
        int card = cards[idx]-1;
        count++;
        if(!visited[card]){
            dfs(cards, count, card);
        }else{
            list.add(count);
        }
    }
}