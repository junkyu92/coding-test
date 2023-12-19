import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        PriorityQueue<Long> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for (int j = 0; j < count; j++) {
                long num = Long.parseLong(st.nextToken());
                if(pq.size() < N) pq.offer(num);
                else if(pq.size()==N && pq.peek() < num) {
                    pq.poll();
                    pq.offer(num);
                }
            }
        }

        bw.write(pq.stream().min(Comparator.naturalOrder()).orElse(0L)+"");
        bw.flush();
    }
}
