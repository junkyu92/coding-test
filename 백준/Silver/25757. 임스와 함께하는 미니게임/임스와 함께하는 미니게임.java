import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int gamePlayers = 0;

        if(game.equals("Y")) gamePlayers = 2;
        else if(game.equals("F")) gamePlayers = 3;
        else if(game.equals("O")) gamePlayers = 4;

        Set<String> set = new HashSet<>();

        //1명당 1번만 플레이
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }

        bw.write(set.size()/(gamePlayers-1) + "");

        bw.flush();
    }
}