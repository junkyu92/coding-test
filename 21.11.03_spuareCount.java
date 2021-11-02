import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		long cnt = 0;
		for(int i = 1; i <= in; i++){
			cnt = cnt + (long)Math.pow(i,2);
		}
		System.out.print(cnt);
	}
}
