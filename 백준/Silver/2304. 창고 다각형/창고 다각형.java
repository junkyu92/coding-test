import java.io.*;
import java.util.*;

public class Main {

    static int d;
    static List<Pillar> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        list = new ArrayList<>();
        int maxH = 0;
        int maxIdx = 0;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Pillar(l, h));
            if(maxH < h){
                maxH = h;
                maxIdx = l;
            }
        }
        d = maxH;
        left(maxIdx);
        right(maxIdx);

        bw.write(d+"");
        bw.flush();
    }

    public static void left(int l){
        Optional<Pillar> max = list.stream().filter(p -> p.l < l).max((p1, p2) -> p1.h - p2.h);
        if(max.isPresent()) {
            Pillar pillar = max.get();
            d += pillar.h * (l - pillar.l);
            left(pillar.l);
        }
    }

    public static void right(int l){
        Optional<Pillar> max = list.stream().filter(p -> p.l > l).max((p1, p2) -> p1.h - p2.h);
        if(max.isPresent()) {
            Pillar pillar = max.get();
            d += pillar.h * (pillar.l - l);
            right(pillar.l);
        }
    }

    static class Pillar {
        int l;
        int h;

        public Pillar(int l, int h) {
            this.l = l;
            this.h = h;
        }
    }
}
