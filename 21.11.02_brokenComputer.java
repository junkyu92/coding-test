import java.io.*;
import java.util.*;
class Main {
	public static int broken(String[] in1, String[] in2){
		int sum = 1;
		for(int i = Integer.parseInt(in1[0])-1; i >= 1; i--){
			if(Integer.parseInt(in2[i])-Integer.parseInt(in2[i-1]) <= Integer.parseInt(in1[1])){
				sum++;
			}else{
				break;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String[] in1 = sc.nextLine().split(" ");
		String[] in2 = sc.nextLine().split(" ");
		System.out.print(broken(in1, in2));
	}
}
