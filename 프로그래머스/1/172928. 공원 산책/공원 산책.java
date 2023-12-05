enum Direction {
    E(0,1),
    S(1,0),
    W(0,-1),
    N(-1,0);
    
    private final int x;
    private final int y;
    
    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int[] getDirection(){
        return new int[]{x,y};
    }
    
}

class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        boolean[][] parkLoad = new boolean[park.length][park[0].length()];
        int x = 0;
        int y = 0;
        
        //park 좌표로 변환, 시작점 설정
        for(int i = 0; i < park.length; i++){
            String[] temp = park[i].split("");
            for(int j = 0; j < temp.length; j++){
                //장애물 false, 길 true
                if(temp[j].equals("X")){
                    parkLoad[i][j] = false;
                }else{
                    parkLoad[i][j] = true;
                }
                //시작점 parkLoad[x][y]
                if(temp[j].equals("S")){
                    x = i;
                    y = j;
                }
            }
        }

        for(int i = 0; i < routes.length; i++){
            
            String[] route = routes[i].split(" ");
            String d = route[0]; //방향
            int m = Integer.parseInt(route[1]); //이동거리
            int[] direction = getDirection(d); //{x,y}
            boolean canMove = true; 
            
            int dx = x;
            int dy = y;
            
            //방향으로 이동 m번 반복
            //중간에 장애물이 있거나 밖으로 나가면 false로 변환해서 명령 취소
            for(int j = 0; j < m; j++){
                dx = dx + direction[0];
                dy = dy + direction[1];
                if(dx<0 || dy<0 || dx>=parkLoad.length || dy>=parkLoad[0].length || parkLoad[dx][dy] == false){
                    canMove = false;
                    break;
                }
            }
            
            //이동 가능 -> 이동
            if(canMove){
                x = dx;
                y = dy;
            }
        }
        
        return new int[]{x, y};
    }
    
    public int[] getDirection(String d){
        if(d.equals("E")) return Direction.E.getDirection();
        else if(d.equals("S")) return Direction.S.getDirection();
        else if(d.equals("W")) return Direction.W.getDirection();
        else return Direction.N.getDirection();
    }
}