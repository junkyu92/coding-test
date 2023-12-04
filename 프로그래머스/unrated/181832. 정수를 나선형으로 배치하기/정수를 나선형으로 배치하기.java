class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int x = 0, y = 0;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int direction = 0;

        while (num <= n * n) {
            answer[x][y] = num++;

            x = x + dx[direction]; 
            y = y + dy[direction];

            if (x < 0 || x >= n || y < 0 || y >= n || answer[x][y] != 0) {
                x = x - dx[direction]; 
                y = y - dy[direction];
                direction = (direction + 1) % 4; //범위 밖에 나갔을 때 방향전환
                x = x + dx[direction];
                y = y + dy[direction];
            }
        }
        return answer;
    }
}