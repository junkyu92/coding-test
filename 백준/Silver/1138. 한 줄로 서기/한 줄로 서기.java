import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N+1; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int j = 0; j < N; j++){
                if (arr[j] == 0) {
                    if(count==num){
                        arr[j] = i;
                        break;
                    }else count++;
                }
            }
        }

        for(int i : arr){
            bw.write(i + " ");
        }

        bw.flush();
    }
}
