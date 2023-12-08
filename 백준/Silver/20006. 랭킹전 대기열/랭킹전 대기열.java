
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //매칭 가능한 방 없으면 새로 생성
        //입장 기준 방장 기준 -10 ~ +10
        //먼저 생성된 방 입장
        //풀방 게임 시작
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Game> gameList = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            User user = new User(level, nickname);
            boolean canJoin = false;
            //게임이 없거나 들어갈 게임이 없을 때
            if(!gameList.isEmpty()){
                for (Game game : gameList) {
                    if(game.canJoin(user)) {
                        game.join(user);
                        canJoin = true;
                        break;
                    }
                }
            }

            if(gameList.isEmpty() || !canJoin){
                gameList.add(new Game(m,user));
            }
        }

        for (Game game : gameList) {
            game.print(bw);
        }

        bw.flush();
    }

    public static class User {
        final int level;
        final String nickname;

        User(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    public static class Game {
        final int size;
        List<User> userList;
        final User creater;

        Game(int size, User user) {
            this.size = size;
            this.userList = new ArrayList<>();
            this.creater = user;
            userList.add(user);
        }

        public boolean canJoin(User user){
            return userList.size() < size && user.level - 10 <= creater.level && user.level + 10 >= creater.level;
        }

        public void join(User user){
            userList.add(user);
        }

        public void print(BufferedWriter bw) throws IOException {
            if(size == userList.size()) bw.write("Started!\n");
            else bw.write("Waiting!\n");
            userList.sort(Comparator.comparing(user -> user.nickname));
            for (User user : userList) {
                bw.write(user.level + " " + user.nickname + "\n");
            }
        }
    }
}
