import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //배열에 자연수 X 삽입
        //배열에서 가장 작은 값을 출력, 그 값을 제거
        PriorityQueue<Long> pq = new PriorityQueue<>();
        //연산 갯수
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if(num == 0){
                if(pq.isEmpty()) bw.write(0+"\n");
                else bw.write(pq.poll()+"\n");
            }else{
                pq.offer(num);
            }
        }
        bw.flush();
    }
}