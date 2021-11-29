import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int in1 = sc.nextInt();
		int[] in2 = new int[in1];
		int[] in3 = new int[in1];
		int num = 0;
		for (int i = 0; i < in1; i++){
			in2[i] = sc.nextInt();
		}
		for (int i = 0; i < in1; i++){
			in3[i] = sc.nextInt();
		}
		Arrays.sort(in2);
		Arrays.sort(in3);
		
		int xMax = 0;
		int yMax = 0;
		int x = 3;
		int y = 3;
		//1~5 2~6 max-4 ~ max
		for (int i = 3; i <= in2[in1-1]-2; i++){
			int cnt = 0;
			for (int j : in2){
				if(j > i+2){
					break;
				}else if(i-2 <= j && j <= i+2){
					cnt++;
				}
			}
			if(xMax < cnt){
				xMax = cnt;
				x = i;
			}
		}
		for (int i = 3; i <= in3[in1-1]-2; i++){
			int cnt = 0;
			for (int j : in3){
				if(j > i+2){
					break;
				}else if(i-2 <= j && j <= i+2){
					cnt++;
				}
			}
			if(yMax < cnt){
				yMax = cnt;
				y = i;
			}
		}
		System.out.println(x+" "+y);
		if(x>y){
			System.out.println("good");
		}else{
			System.out.println("bad");
		}
	}
}
