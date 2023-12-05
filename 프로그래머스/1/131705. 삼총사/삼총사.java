class Solution {
    //학생 정수 번호 
    //3명의 번호를 더했을 때 0 -> 삼총사
    //완전탐색 dfs
    static boolean[] visited;
    static int answer;
    public int solution(int[] number) {
        answer = 0;
        visited = new boolean[number.length];
        for(int i = 0; i < number.length; i++){
            visited[i] = true;
            dfs(number, i, 0, 0);
        }
        return answer;
    }
    
    public void dfs(int[] number, int idx, int sumParam, int depth) {
        int sum = sumParam + number[idx];
        if(depth == 2) {
            if(sum == 0) answer++;
        }
        
        for(int j = idx; j < number.length; j++){
            if(!visited[j] && depth < 2){
                visited[j] = true;
                dfs(number, j, sum, depth+1);
                visited[j] = false;
            }
        }
    }
}