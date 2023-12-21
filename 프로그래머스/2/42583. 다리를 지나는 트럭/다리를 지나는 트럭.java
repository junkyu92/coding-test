import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Truck> onBridge = new LinkedList<>();
        Queue<Truck> wait = new LinkedList<>();
        int onBridgeWeight = 0;
        
        for(int i : truck_weights){
            wait.offer(new Truck(i));
        }
        
        onBridgeWeight += wait.peek().weight;
        onBridge.offer(wait.poll());
        
        while(!onBridge.isEmpty() || !wait.isEmpty()){
            answer++;
        
            onBridge.forEach(Truck::plus);
            
            if(onBridge.peek().second >= bridge_length) {
                onBridgeWeight -= onBridge.peek().weight;
                onBridge.poll();
            }
            
            if(!wait.isEmpty() && onBridgeWeight + wait.peek().weight <= weight) {
                onBridgeWeight += wait.peek().weight;
                onBridge.offer(wait.poll());
            }
        }
        
        return answer;
    }
}

class Truck {
    int weight;
    int second;
    
    Truck(int weight){
        this.weight = weight;
        second = 0;
    }
    
    public void plus(){
        second++;
    }
}