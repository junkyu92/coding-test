import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int in1 = sc.nextInt();
		sc.nextLine();
		String[] in2 = sc.nextLine().split(" ");
		int min = 99999999;
		for (int i = 0; i < in2.length; i++){
			if(Integer.parseInt(in2[i])<min){
				min = Integer.parseInt(in2[i]);
			}
		}
		System.out.print(min);
	}
}
