import java.util.*;
class Solution {
    boolean[] visited;
    List<List<Edge>> list;
    int[] timeArr;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        list = new ArrayList<>();
        visited = new boolean[N+1];
        timeArr = new int[N+1];
        Arrays.fill(timeArr, Integer.MAX_VALUE);
        
        for(int i = 0; i < N+1; i++){
            list.add(new ArrayList<>());
        }
        
        //모든 엣지 인접리스트에 저장
        for(int[] r : road){
            list.get(r[0]).add(new Edge(r[1], r[2]));
            list.get(r[1]).add(new Edge(r[0], r[2]));
        }
        
        dijkstra(1);
        
        return (int)Arrays.stream(timeArr).filter(i -> i <= K).count();
    }
    
    public void dijkstra(int start){
        Queue<Edge> q = new PriorityQueue<>((e1,e2) -> e1.hour - e2.hour);
        q.offer(new Edge(start,0));
        
        timeArr[start] = 0;
        
        while(!q.isEmpty()) {
			Edge edge = q.poll();
			int endNodeIdx = edge.endNodeIdx;
			
			if(!visited[endNodeIdx]) visited[endNodeIdx] = true;
			
			for(Edge e : list.get(endNodeIdx)) {
				if(timeArr[e.endNodeIdx]  >= timeArr[endNodeIdx] + e.hour) {
					timeArr[e.endNodeIdx] = timeArr[endNodeIdx] + e.hour;
					q.offer(new Edge(e.endNodeIdx, timeArr[e.endNodeIdx]));
				}
			}
		}
    }
}

class Edge {
    int endNodeIdx;
    int hour;
    
    Edge(int endNodeIdx, int hour){
        this.endNodeIdx = endNodeIdx;
        this.hour = hour;
    }
}
