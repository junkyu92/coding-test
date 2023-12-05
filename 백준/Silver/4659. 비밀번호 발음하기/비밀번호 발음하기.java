import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String pw = br.readLine();
            if(pw.equals("end")) break;
            boolean firstCondition = pw.contains("a") || pw.contains("e") || pw.contains("i") || pw.contains("o") || pw.contains("u");
            boolean secondCondition = second(pw);
            boolean thirdCondition = third(pw);
            if(firstCondition && secondCondition && thirdCondition) {
                bw.write("<" + pw + "> is acceptable.\n");
            }else{
                bw.write("<" + pw + "> is not acceptable.\n");
            }
        }
        bw.flush();
    }

    public static boolean second(String pw) {
        String[] s = pw.split("");
        for (int i = 0; i < s.length-2; i++) {
            if(isVowels(s[i]) && isVowels(s[i+1]) && isVowels(s[i+2])) return false;
            if(!isVowels(s[i]) && !isVowels(s[i+1]) && !isVowels(s[i+2])) return false;
        }
        return true;
    }
    
    public static boolean isVowels(String pw) {
        return pw.equals("a") || pw.equals("e") || pw.equals("i") || pw.equals("o") || pw.equals("u");
    }

    public static boolean third(String pw) {
        String[] s = pw.split("");
        for (int i = 0; i < s.length-1; i++) {
            if(s[i].equals(s[i+1]) && !s[i].equals("e") && !s[i].equals("o")) return false;
        }
        return true;
    }
}