import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        List<Long> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for (int j = 0; j < count; j++) {
                list.add(Long.parseLong(st.nextToken()));
            }
        }

        bw.write(list.stream().sorted(((o1, o2) -> Math.toIntExact(o2 - o1))).collect(Collectors.toList()).get(N-1)+"");
        bw.flush();
    }

}
