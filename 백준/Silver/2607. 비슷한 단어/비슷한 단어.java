import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        //해시
        //배열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String firstWord = br.readLine();
        int[] arr = new int[26];
        int answer = 0;

        //배열에 각 알파벳 갯수 저장
        for (int i = 0; i < firstWord.length(); i++) {
            arr[firstWord.charAt(i) - 65]++;
        }

        //배열에서 각 알파벳의 갯수 -
        //배열에서 0이 아닌 갯수 1이하이면 answer++
        for (int i = 0; i < n - 1; i++) {
            int[] temp = arr.clone();
            String word = br.readLine();

            if(Math.abs(word.length() - firstWord.length()) <= 1) {
                for (int j = 0; j < word.length(); j++) {
                    temp[word.charAt(j) - 65]--;
                }

                long countNotZero = Arrays.stream(temp)
                        .filter(t -> t != 0)
                        .count();

                long countOVer = Arrays.stream(temp)
                        .filter(t -> t < -1 || t > 1)
                        .count();

                long countOne = Arrays.stream(temp)
                        .filter(t -> t == 1)
                        .count();
                long countMinusOne = Arrays.stream(temp)
                        .filter(t -> t == -1)
                        .count();

                if(countNotZero==0) answer++;
                else if (countOVer == 0 && countOne <= 1 && countMinusOne<=1) {
                    answer++;
                }
            }
        }

        bw.write(answer+"");

        bw.flush();
    }
}