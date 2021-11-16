import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] in1 = sc.nextLine().split(" ");
		int[] in2 = new int[Integer.parseInt(in1[0])];
		int[] in3 = new int[Integer.parseInt(in1[1])];
		int cnt2 = 0;
		int cnt3 = 0;
		for (int i = 0; i < Integer.parseInt(in1[0]); i++){
			in2[i] = sc.nextInt();
		}
		
		for (int i = 0; i < Integer.parseInt(in1[1]); i++){
			in3[i] = sc.nextInt();
		}
		
		while(cnt2 != in2.length || cnt3 != in3.length){
			if(cnt2 == in2.length){
				for(int i = cnt3; i < in3.length; i++){
					System.out.print(in3[i] + " ");
				}
				break;
			}
			if(cnt3 == in3.length){
				for(int i = cnt2; i < in2.length; i++){
					System.out.print(in3[i] + " ");
				}
				break;
			}
			if (in2[cnt2] < in3[cnt3]){
					System.out.print(in2[cnt2] + " ");
					cnt2++;
			}else{
					System.out.print(in3[cnt3] + " ");
					cnt3++;
			}
		}
	}
}
