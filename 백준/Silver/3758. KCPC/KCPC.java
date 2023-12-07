import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //k개 문제 0~100점
        //팀Id, 문제번호, 점수 : 제출 시간순으로 저장
        //여러 번 제출 최고점수가 최종점수
        //미제출 0
        //최종 점수가 같은 경우, 제출 횟수가 적은 팀의 순위가 높다.
        //최종 점수도 같고 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀의 순위가 높다.

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long answer = 1;
            int[][] scoreArr = new int[n+1][k+1];
            Map<Integer, Integer> map = new HashMap<>();
            int[] lastCommit = new int[n+1];

            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                scoreArr[id][num] = Math.max(score, scoreArr[id][num]);
                map.put(id, map.getOrDefault(id, 0)+1);
                lastCommit[id] = j;
            }

            int[] totalScore = Arrays.stream(scoreArr)
                    .mapToInt(arr -> Arrays.stream(arr).sum())
                    .toArray();

            int tScore = totalScore[t];

            answer += Arrays.stream(totalScore)
                    .filter(s -> s > tScore)
                    .count();

            int sameScoreCount = (int) Arrays.stream(totalScore)
                    .filter(s -> s == tScore)
                    .count();

            if(sameScoreCount>0){
                int[] array = IntStream.range(0, totalScore.length)
                        .filter(a -> totalScore[a] == tScore)
                        .toArray();
                for (int a : array) {
                    if(a!=t) {
                        if(map.get(t) > map.get(a)) answer++;
                        else if(Objects.equals(map.get(t), map.get(a))){
                            if(lastCommit[t] > lastCommit[a]) answer++;
                        }
                    }
                }
            }

            bw.write(answer+"\n");
        }

        bw.flush();
    }
}