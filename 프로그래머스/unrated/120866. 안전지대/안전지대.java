import java.util.*;
class Solution {
    public int solution(int[][] board) {
        int[][] cloneArr = new int[board.length][board.length];
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j]==1) {
                    boolean iNotMinus = i-1>=0;
                    boolean jNotMinus = j-1>=0;
                    boolean iNotOver = i+1<board.length;
                    boolean jNotOver = j+1<board.length;
                    cloneArr[i][j]=1;
                    if(iNotMinus) cloneArr[i-1][j]=1;
                    if(jNotMinus) cloneArr[i][j-1]=1;
                    if(iNotOver) cloneArr[i+1][j]=1;
                    if(jNotOver) cloneArr[i][j+1]=1;
                    if(iNotMinus && jNotMinus) cloneArr[i-1][j-1]=1;
                    if(iNotOver && jNotMinus) cloneArr[i+1][j-1]=1;
                    if(iNotMinus && jNotOver) cloneArr[i-1][j+1]=1;
                    if(iNotOver && jNotOver) cloneArr[i+1][j+1]=1;
                }
            }
        }
        return (int)Arrays.stream(cloneArr)
            .flatMapToInt(Arrays::stream)
            .filter(i -> i == 0)
            .count();
        
    }
}