import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int in1 = sc.nextInt();
		int[] in2 = new int[in1];
		for (int i = 0; i < in1; i++){
			in2[i] = sc.nextInt();
		}
		int in3 = sc.nextInt();
		if(Arrays.binarySearch(in2, in3)<0){
			System.out.println("X");
		}else{
			System.out.println(Arrays.binarySearch(in2, in3)+1);
		}
	}
}
