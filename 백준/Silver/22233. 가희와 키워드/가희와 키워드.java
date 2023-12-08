import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //키워드 N개
        //글 1개당 최대 10개 키워드
        //글 쓴 후 키워드 삭제
        Set<String> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String keyword = br.readLine();
            set.add(keyword);
        }

        for (int i = 0; i < m; i++) {
            String[] useKeywords = br.readLine().split(",");
            for (int j = 0; j < useKeywords.length; j++) {
                set.remove(useKeywords[j]);
            }
            bw.write(set.size()+"\n");
        }
        bw.flush();
    }
}