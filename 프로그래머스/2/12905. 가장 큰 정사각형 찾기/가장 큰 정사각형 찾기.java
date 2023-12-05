import java.util.*;
class Solution
{
    static int answer;
    public int solution(int [][]board)
    {
        if(Arrays.stream(board).flatMapToInt(a->Arrays.stream(a)).filter(i -> i==1).count() == 0) return 0;
        
        answer = 1;
        
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){
                if(board[i][j]==1) {
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        
        return answer*answer;
    }
}